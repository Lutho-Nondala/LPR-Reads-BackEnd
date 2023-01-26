package com.lpr.afsol.LPR.Reads.Service;

import com.lpr.afsol.LPR.Reads.Entity.Vehicle;
import com.lpr.afsol.LPR.Reads.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.spi.NumberFormatProvider;
import java.util.List;
import java.util.Set;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository REPOSITORY;

    public Vehicle create(Vehicle vehicle){
        return REPOSITORY.save(vehicle);
    }

    public Vehicle read(long id){
        return REPOSITORY.findById(id).get();
    }

    public Vehicle findVehicleByNumberPlate(String numberPlate){
        return REPOSITORY.findVehicleByNumberPlate(numberPlate);
    }

    public Vehicle update(Vehicle vehicle){
        Vehicle update = new Vehicle();
        try{
            update = this.findVehicleByNumberPlate(vehicle.getNumberPlate());
            update.setMake(vehicle.getMake());
            update.setModel(vehicle.getModel());
            update.setColor(vehicle.getColor());
            update.setFeatures(vehicle.getFeatures());
            update.setNotes(vehicle.getNotes());
            return REPOSITORY.save(update);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid number plate registration", e);
        }
    }

    public void delete(long id){
        REPOSITORY.deleteById(id);
    }

    public void deleteVehicleByNumberPlate(String numberPlate){
        REPOSITORY.deleteVehicleByNumberPlate(numberPlate);
    }

    public List<Vehicle> getAll(){
        return REPOSITORY.findAll();
    }
}
