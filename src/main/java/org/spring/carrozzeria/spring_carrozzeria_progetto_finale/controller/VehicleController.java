package org.spring.carrozzeria.spring_carrozzeria_progetto_finale.controller;

import java.util.List;

import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.model.Maintenance;
import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.model.Vehicle;
import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.repository.MaintenanceRepository;
import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/vehicles")

public class VehicleController {

    private final MaintenanceRepository maintenanceRepository;
    
    @Autowired
    private VehicleService vehicleService;

    VehicleController(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @GetMapping
    public String index(@RequestParam(name="name", required = false) String name, Model model){
        List<Vehicle> vehicles = vehicleService.findAll(name);

        model.addAttribute("vehicles", vehicles);
        model.addAttribute("name", name);

        return "vehicles/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model){
        model.addAttribute("vehicle", vehicleService.getById(id));
        return "vehicles/show";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("vehicle", new Vehicle());
        return "vehicles/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("vehicle") Vehicle formvehicle, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return "vehicles/create";
        }
        vehicleService.create(formvehicle);

        return "redirect:/vehicles";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("vehicle", vehicleService.getById(id));
        return "vehicles/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("vehicle") Vehicle formVehicle, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "vehicles/edit";
        }
        vehicleService.update(formVehicle);
        
        return "redirect:/vehicles";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        Vehicle vehicle = vehicleService.getById(id);

        for(Maintenance maintenanceToDelete : vehicle.getMaintenances()){
            maintenanceRepository.delete(maintenanceToDelete);
        }

        vehicleService.delete(vehicle);

        return "redirect:/vehicles";
    }
}
