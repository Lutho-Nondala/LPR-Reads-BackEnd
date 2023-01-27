package com.lpr.afsol.LPR.Reads.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String numberPlate;
    private String make;
    private String model;
    private String color;
    private String features;
    private String notes;

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", numberPlate='" + numberPlate + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", features='" + features + '\'' +
                ", notes='" + notes + '\'' +
                ", lpr=" + lpr +
                '}';
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle", orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<LPR> lpr;

    public Vehicle(){

    }

    public Vehicle(Builder builder){
        this.id = builder.id;
        this.numberPlate = builder.numberPlate;
        this.make = builder.make;
        this.model = builder.model;
        this.color = builder.color;
        this.features = builder.features;
        this.notes = builder.notes;
        this.lpr = builder.lpr;
    }

    public Set<LPR> getLpr() {
        return lpr;
    }

    public void setLpr(Set<LPR> lpr) {
        this.lpr = lpr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static class Builder{
        private long id;
        private String numberPlate, make, model, color, features, notes;

        private Set<LPR> lpr;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder numberPlate(String numberPlate){
            this.numberPlate = numberPlate;
            return this;
        }

        public Builder make(String make){
            this.make = make;
            return this;
        }

        public Builder model(String model){
            this.model = model;
            return this;
        }

        public Builder color(String color){
            this.color = color;
            return this;
        }

        public Builder features(String feautures){
            this.features = features;
            return this;
        }

        public Builder notes(String notes){
            this.notes = notes;
            return this;
        }

        public Builder lpr(Set<LPR> lpr){
            this.lpr = lpr;
            return this;
        }

        public Builder copy(Vehicle vehicle){
            this.id = vehicle.id;
            this.numberPlate = vehicle.numberPlate;
            this.make = vehicle.make;
            this.model = vehicle.model;
            this.color = vehicle.color;
            this.features = vehicle.features;
            this.notes = vehicle.notes;
            this.lpr = vehicle.lpr;
            return this;
        }

        public Vehicle build(){
            return new Vehicle(this);
        }

    }
}
