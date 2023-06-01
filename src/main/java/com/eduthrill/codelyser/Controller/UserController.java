package com.eduthrill.codelyser.Controller;


import com.eduthrill.codelyser.Entity.Role;
import com.eduthrill.codelyser.Entity.User;
import com.eduthrill.codelyser.Entity.UserRole;
import com.eduthrill.codelyser.Exception.UserWithSameUserNameException;
import com.eduthrill.codelyser.Model.CategoryModel;
import com.eduthrill.codelyser.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncorder;


    @PostMapping("/")
    public User createNewUser(@RequestBody User theuser) throws Exception {
        try {
            User user=this.userService.findUser(theuser.getUsername());
            if(user!=null) {
                throw new UserWithSameUserNameException(theuser.getUsername());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        theuser.setProfile("default.png");
        theuser.setPassword(this.bcryptPasswordEncorder.encode(theuser.getPassword()));
        Set<UserRole> userroles=new HashSet<>();
        Role role=new Role();
        role.setRoleName("USER");
        UserRole userrole=new UserRole();
        userrole.setRole(role);
        userrole.setUser(theuser);
        userroles.add(userrole);
        return this.userService.createUser(theuser, userroles);

    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.findUser(username);

    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId")Long userId) {
        this.userService.deleteUser(userId);
        return "user with userid "+userId+" is deleted successfully";
    }
    @PutMapping("/updateUser/{user_id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable long user_id) {
        user.setUser_id(user_id);
        return ResponseEntity.ok().body(this.userService.updateUser(user));
    }
}

