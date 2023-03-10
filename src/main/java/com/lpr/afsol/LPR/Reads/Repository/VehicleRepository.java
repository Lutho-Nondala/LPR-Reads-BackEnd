package com.lpr.afsol.LPR.Reads.Repository;

import com.lpr.afsol.LPR.Reads.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findVehicleByNumberPlate(String numberPlate);

    void deleteVehicleByNumberPlate(String numberPlate);
}
