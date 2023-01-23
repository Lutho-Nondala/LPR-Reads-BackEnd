package com.lpr.afsol.LPR.Reads.Factory;

import com.lpr.afsol.LPR.Reads.Entity.LPR;
import com.lpr.afsol.LPR.Reads.Entity.Vehicle;

import java.util.Set;

public class VehicleFactory {
    public static Vehicle buildVehicle(String numberPlate, String make, String model, String color, String features, String notes, Set<LPR> lpr){
        if (numberPlate.isEmpty() || numberPlate == null){
            throw new IllegalArgumentException("Number Plate is required");
        }
        if (make.isEmpty() || make == null){
            throw new IllegalArgumentException("Make is required");
        }
        if (model.isEmpty() || model == null){
            throw new IllegalArgumentException("Model is required");
        }
        if (color.isEmpty() || color == null){
            throw new IllegalArgumentException("Color is required");
        }
        if (features.isEmpty() || features == null){
            throw new IllegalArgumentException("Features are required");
        }
        if (notes.isEmpty() || notes == null){
            throw new IllegalArgumentException("Notes are required");
        }
        if (lpr == null){
            throw new IllegalArgumentException("LPRs are required");
        }

        return new Vehicle.Builder().numberPlate(numberPlate).make(make).model(model).color(color).features(features).notes(notes).lpr(lpr).build();
    }
}
