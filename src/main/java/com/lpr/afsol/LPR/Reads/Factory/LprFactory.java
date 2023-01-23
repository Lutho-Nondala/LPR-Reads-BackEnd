package com.lpr.afsol.LPR.Reads.Factory;

import com.lpr.afsol.LPR.Reads.Entity.Images;
import com.lpr.afsol.LPR.Reads.Entity.LPR;
import com.lpr.afsol.LPR.Reads.Entity.Vehicle;

import java.sql.Time;
import java.util.Set;

public class LprFactory {
    public static LPR buildLpr(Vehicle vehicle, Time time, String camera, String location, Set<Images> lprImages){
        if (vehicle == null){
            throw new IllegalArgumentException("Number plate is needed.");
        }
        if (time == null){
            throw new IllegalArgumentException("Number plate is needed.");
        }
        if (camera.isEmpty() || camera == null){
            throw new IllegalArgumentException("Number plate is needed.");
        }
        if (location.isEmpty() || location == null){
            throw new IllegalArgumentException("Number plate is needed.");
        }
        if (lprImages.isEmpty() || lprImages == null){
            throw new IllegalArgumentException("Number plate is needed.");
        }

        return new LPR.Builder().vehicle(vehicle).time(time).camera(camera).location(location).lprImages(lprImages).build();
    }
}
