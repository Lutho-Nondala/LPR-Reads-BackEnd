package com.lpr.afsol.LPR.Reads.Service;

import com.lpr.afsol.LPR.Reads.Entity.Images;
import com.lpr.afsol.LPR.Reads.Entity.LPR;
import com.lpr.afsol.LPR.Reads.Entity.Vehicle;
import com.lpr.afsol.LPR.Reads.Repository.ImageRepository;
import com.lpr.afsol.LPR.Reads.Repository.LprRepository;
import com.lpr.afsol.LPR.Reads.Repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class LprService {
    @Autowired
    private LprRepository REPOSITORY;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ImageRepository imgRepo;

    public LPR create(LPR lpr, long vehicleId){
        Vehicle vehicle = this.vehicleRepository.findById(vehicleId).get();
        vehicle.getLpr().add(lpr);
        log.info(vehicle.toString());
        Vehicle update = this.vehicleRepository.save(vehicle);
        return lpr;
    }

    public LPR read(long id){
        return this.REPOSITORY.findById(id).get();
    }

    public LPR update(LPR lpr){
        return this.REPOSITORY.save(lpr);
    }

    public void delete(long id){
        this.REPOSITORY.deleteById(id);
    }

//    public List<LPR> findLprByNumberPlate(String numberPlate){
//        return this.REPOSITORY.findLprByNumberPlate(numberPlate);
//    }
//
//    public void deleteLprByNumberPlate(String numberPlate){
//        this.REPOSITORY.deleteLprByNumberPlate(numberPlate);
//    }

    public List<LPR> getAll(){
        return this.REPOSITORY.findAll();
    }
}
