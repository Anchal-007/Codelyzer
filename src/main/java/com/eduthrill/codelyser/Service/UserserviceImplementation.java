package com.eduthrill.codelyser.Service;


import com.eduthrill.codelyser.Entity.Category;
import com.eduthrill.codelyser.Entity.Quiz;
import com.eduthrill.codelyser.Entity.User;
import com.eduthrill.codelyser.Entity.UserRole;
import com.eduthrill.codelyser.Exception.UserWithSameUserNameException;
import com.eduthrill.codelyser.Model.CategoryModel;
import com.eduthrill.codelyser.Repository.RoleRepository;
import com.eduthrill.codelyser.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserserviceImplementation implements UserService {
	@Autowired
    private UserRepository userRepository;

    @Autowired

    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncorder;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User theUser=this.userRepository.findByUsername(user.getUsername());

        if(theUser!=null) {
            System.out.println("This username is already exit");
            throw new Exception("this username already exist try again");
        }

        else {
            for(UserRole userrole:userRoles) {
                this.roleRepository.save(userrole.getRole());
            }
            user.getUserRole().addAll(userRoles);
            theUser=this.userRepository.save(user);
        }
        return theUser;
    }

    public User findUser(String username) {

        return this.userRepository.findByUsername(username);

    }

    public void deleteUser(Long id) {

        this.userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {

        Optional<User> u = this.userRepository.findById(user.getUser_id());
        if (u.isPresent()) {
            User userUpdate = u.get();
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPassword(this.bcryptPasswordEncorder.encode(user.getPassword()));
            userUpdate.setFirstname(user.getFirstname());
            userUpdate.setLastname(user.getLastname());
            userUpdate.setPhonenumber(user.getPhonenumber());
            userUpdate.setEnabled(user.isEnabled());
            userUpdate.setUsername(user.getUsername());
            return this.userRepository.save(userUpdate);
        }
        else{
            throw new UserWithSameUserNameException("quiz id not found");
        }

    }

}
