package com.eduthrill.codelyser.Service;

import com.eduthrill.codelyser.Entity.User;
import com.eduthrill.codelyser.Exception.UserNotFoundException;
import com.eduthrill.codelyser.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private UserRepository theuserrepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User theuser=this.theuserrepository.findByUsername(username);

        if(theuser==null) {
            System.out.println("user not found");
            try {
                throw new UserNotFoundException(username);
            } catch (UserNotFoundException e) {

                e.printStackTrace();
            }
        }
        return theuser;
    }


}