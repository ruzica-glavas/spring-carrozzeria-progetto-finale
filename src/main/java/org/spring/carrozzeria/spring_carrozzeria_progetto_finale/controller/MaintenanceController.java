package org.spring.carrozzeria.spring_carrozzeria_progetto_finale.controller;

import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.model.Maintenance;
import org.spring.carrozzeria.spring_carrozzeria_progetto_finale.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/maintenances")

public class MaintenanceController {
    
    @Autowired
    private MaintenanceService maintenanceService;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("maintenance") Maintenance forMaintenance, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            return "maintenances/create-or-edit";
        }

        maintenanceService.create(forMaintenance);

        return "redirect:/vehicles";
    }

    //Metodo che resituisce una edit da compilare (con già i dati inseriti)

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("maintenance", maintenanceService.getById(id));
        model.addAttribute("edit", true);

        return "maintenances/create-or-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("maintenance") Maintenance forMaintenance, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "maintenances/create-or-edit";
        }

        maintenanceService.update(forMaintenance);

        return "redirect:/vehicles/" + forMaintenance.getVehicle().getId();
    }
}
