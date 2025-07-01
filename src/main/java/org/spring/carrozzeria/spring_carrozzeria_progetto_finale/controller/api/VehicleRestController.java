package org.spring.carrozzeria.spring_carrozzeria_progetto_finale.controller.api;

import java.util.List;
import java.util.Optional;

import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.model.Vehicle;
import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("api/vehicles")

public class VehicleRestController {
    
    @Autowired
    VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> index(){
        List<Vehicle> vehicles = vehicleService.findAll();

        return vehicles;
    }

    @GetMapping("{id}")
    public ResponseEntity<Vehicle> show(@PathVariable("id") Integer id){
        Optional<Vehicle> vehicleAttempt = vehicleService.findById(id);

        if(vehicleAttempt.isPresent()){
            return new ResponseEntity<Vehicle>(vehicleAttempt.get(),HttpStatus.OK);
        }

        return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Vehicle> store(@Valid @RequestBody Vehicle vehicle){
        return new ResponseEntity<Vehicle>(vehicleService.create(vehicle), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Vehicle> update(@Valid @RequestBody Vehicle vehicle, @PathVariable("id") Integer id){
        Optional<Vehicle> vehicleAttempt = vehicleService.findById(id);

        if (vehicleAttempt.isPresent()) {
            return new ResponseEntity<Vehicle>(vehicleService.update(vehicle), HttpStatus.OK);
        }

        return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Vehicle> delete(@PathVariable("id") Integer id){
        Optional<Vehicle> vehicleAttempt = vehicleService.findById(id);

        if (vehicleAttempt.isPresent()) {
            vehicleService.deleteById(id);
            return new ResponseEntity<Vehicle>(HttpStatus.OK);
        }

        return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
    }

}
