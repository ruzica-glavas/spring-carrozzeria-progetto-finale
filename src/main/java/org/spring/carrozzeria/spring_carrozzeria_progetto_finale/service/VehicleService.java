package org.spring.carrozzeria.spring_carrozzeria_progetto_finale.service;

import java.util.List;
import java.util.Optional;

import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.model.Maintenance;
import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.model.Vehicle;
import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.repository.MaintenanceRepository;
import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    
    @Autowired 
    VehicleRepository vehicleRepository;

    @Autowired
    MaintenanceRepository maintenanceRepository;

    public List<Vehicle> findAll(String brand){
        if(brand!=null && !brand.isBlank()){
            return vehicleRepository.findByBrandContainingIgnoreCase(brand);
        }else{
            return vehicleRepository.findAll();
        }
    }

    public List<Vehicle> findAll(){
        return vehicleRepository.findAll();
    }

    public Vehicle getById(Integer id){
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(vehicle.isEmpty()){
            throw new IllegalArgumentException("Vehicle not found with id:" + id);
        }
        return vehicle.get();
    }

    public Optional<Vehicle> findById(Integer id){
        return vehicleRepository.findById(id);
    }

    public Vehicle create(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public Vehicle update(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public void deleteById(Integer id){
        vehicleRepository.deleteById(id);
    }

    public void delete(Vehicle vehicle){
        for(Maintenance maintenanceToDelete : vehicle.getMaintenances()){
            maintenanceRepository.delete(maintenanceToDelete);
        }
        vehicleRepository.delete(vehicle);
    }

    public boolean exists(Vehicle vehicle){
        return vehicleRepository.existsById(vehicle.getId());
    }

    public boolean existsById(Integer id){
        return vehicleRepository.existsById(id);
    }
}
