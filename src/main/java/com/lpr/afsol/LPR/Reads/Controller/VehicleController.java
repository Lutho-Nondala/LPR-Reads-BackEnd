package com.lpr.afsol.LPR.Reads.Controller;

import com.lpr.afsol.LPR.Reads.Entity.Vehicle;
import com.lpr.afsol.LPR.Reads.Service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lprreads/vehicle/")
@Slf4j
public class VehicleController {
    @Autowired
    private VehicleService SERVICE;

    @PostMapping("create")
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle){
        return ResponseEntity.ok(this.SERVICE.create(vehicle));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Vehicle> read(@PathVariable long id){
        return ResponseEntity.ok(this.SERVICE.read(id));
    }

    @GetMapping("findByNumberPlate/{numberPlate}")
    public  ResponseEntity<List<Vehicle>> findVehiclesByNumberPlate(@PathVariable String numberPlate){
        return ResponseEntity.ok(this.SERVICE.findVehiclesByNumberPlate(numberPlate));
    }

    @PutMapping("update")
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle vehicle){
        return ResponseEntity.ok(this.SERVICE.update(vehicle));
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable long id){
        this.SERVICE.delete(id);
    }

    @DeleteMapping("deleteVehicleByNumberPlate/{numberPlate}")
    public void deleteVehicleByNumberPlate(@PathVariable String numberPlate){
        this.SERVICE.deleteVehicleByNumberPlate(numberPlate);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Vehicle>> getAll(){
        return ResponseEntity.ok(this.SERVICE.getAll());
    }
}