package org.spring.carrozzeria.spring_carrozzeria_progetto_finale.security;

import java.util.Optional;

import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.model.User;
import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<User> userAttempt = userRepository.findByUsername(username);

        if (userAttempt.isPresent()) {
            return  new DatabaseUserDetails(userAttempt.get());
        } else{
            throw new UnsupportedOperationException("No User with this Username have been found");
        }

        
    }
    
}
