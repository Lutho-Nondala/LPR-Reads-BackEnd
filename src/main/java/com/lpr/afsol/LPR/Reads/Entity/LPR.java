package com.lpr.afsol.LPR.Reads.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Set;

@Entity
public class LPR {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @JsonBackReference
    private Vehicle vehicle;
    private String time;
    private String camera;
    private String location;
    @OneToMany(mappedBy = "lpr", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Images> lprImages;

    public LPR(){

    }

    public LPR(Builder builder){
        this.id = builder.id;
        this.vehicle = builder.vehicle;
        this.time = builder.time;
        this.camera = builder.camera;
        this.location = builder.location;
        this.lprImages = builder.lprImages;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Images> getLprImages() {
        return lprImages;
    }

    public void setLprImages(Set<Images> lprImages) {
        this.lprImages = lprImages;
    }

    public static class Builder{
        private long id;
        private String time;

        private Vehicle vehicle;
        private String camera, location;
        private Set<Images> lprImages;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder vehicle(Vehicle vehicle){
            this.vehicle = vehicle;
            return this;
        }

        public Builder time(String time){
            this.time = time;
            return this;
        }

        public Builder camera(String camera){
            this.camera = camera;
            return this;
        }

        public Builder location(String location){
            this.location = location;
            return this;
        }

        public Builder lprImages(Set<Images> lprImages){
            this.lprImages = lprImages;
            return this;
        }

        public Builder copy(LPR lpr){
            this.id = lpr.id;;
            this.vehicle = lpr.vehicle;
            this.time = lpr.time;
            this.camera = lpr.camera;
            this.location = lpr.location;;
            this.lprImages = lpr.lprImages;
            return this;
        }

        public LPR build(){
            return new LPR(this);
        }
    }
}
