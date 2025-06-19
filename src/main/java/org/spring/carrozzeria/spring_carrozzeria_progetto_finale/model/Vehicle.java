package org.spring.carrozzeria.spring_carrozzeria_progetto_finale.model;

import java.time.Year;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Plate Number cannot be null nor empty or blank")
    private String plateNumber;

    @NotBlank(message = "Brand cannot be null nor empty or blank")
    private String brand;

    @NotNull //Può essere vuota
    private String model;

    @PastOrPresent
    private Year year;

    @Size(min=11, max=17, message="VIN must be between 11 and 17 charachters")
    private String vin;

    @Lob
    private String photo;

    @NotBlank(message="Owner name cannot be null nor empty or blank")
    private String ownerName;

    @NotBlank(message = "Owner phone cannnot be null nor empty or blank")
    private String ownerPhone;

    //Maintence
    @OneToMany(mappedBy = "vehicle")
    private List<Maintenance> maintenances;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getYear() {
        return this.year;
    }

    public void setYear(@PastOrPresent Year year) {
        this.year = year;
    }

    public String getVin() {
        return this.vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return this.ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public List<Maintenance> getMaintenances() {
        return this.maintenances;
    }

    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }

}
