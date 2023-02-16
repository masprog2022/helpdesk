package com.masprogtechs.helpdesk.security.service;

import com.masprogtechs.helpdesk.entities.User;
import com.masprogtechs.helpdesk.security.jwt.JwtUserFactory;
import com.masprogtechs.helpdesk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userService.findByEmail(email);

        if(user == null){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'. ", email));
        } else {
            return JwtUserFactory.create(user);
        }

    }
}
