package org.spring.carrozzeria.spring_carrozzeria_progetto_finale.repository;


import java.util.Optional;

import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer>{  
    
    Optional<User> findByUsername(String username);
} 
