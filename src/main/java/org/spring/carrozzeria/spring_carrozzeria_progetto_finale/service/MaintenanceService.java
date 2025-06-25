package org.spring.carrozzeria.spring_carrozzeria_progetto_finale.service;

import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.model.Maintenance;
import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public Maintenance create(Maintenance maintenance){
        return maintenanceRepository.save(maintenance);
    }

    public Maintenance update(Maintenance maintenance){
        return maintenanceRepository.save(maintenance);
    }

    public Maintenance getById(Integer id){
        return maintenanceRepository.findById(id).get();
    }

    public void deleteById(Integer id){
        maintenanceRepository.deleteById(id);
    }
    
}
