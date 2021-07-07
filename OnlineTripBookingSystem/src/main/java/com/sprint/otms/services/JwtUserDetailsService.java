package com.sprint.otms.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sprint.otms.repositories.IUserRepository;

 
@Service
public class JwtUserDetailsService implements UserDetailsService {

 

    @Autowired
    private UserServiceImpl service;
    @Autowired
    private IUserRepository repo;

 

    @Autowired
    private PasswordEncoder bcryptEncoder;

 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
          com.sprint.otms.models.User user =  repo.findByEmail(username).get(0);
          
          com.sprint.otms.models.User validuser= service.findUser(user);
          System.out.println(user);
          System.out.println(validuser);
          if(validuser==null)
        	  
              throw new UsernameNotFoundException("user not found"+username);
          
          return  new org.springframework.security.core.userdetails.User(validuser.getEmail(), validuser.getPassword(), new ArrayList<>());
          
    
    }

 

    public com.sprint.otms.models.User save(com.sprint.otms.models.User user) {
        com.sprint.otms.models.User newUser = new com.sprint.otms.models.User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return service.addUser(newUser);
    }

 

}







