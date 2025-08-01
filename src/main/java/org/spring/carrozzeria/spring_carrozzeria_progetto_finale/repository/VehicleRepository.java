package org.spring.carrozzeria.spring_carrozzeria_progetto_finale.repository;

import java.util.List;

import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    public List<Vehicle> findByBrandContainingIgnoreCase(String brand);
    
} 
