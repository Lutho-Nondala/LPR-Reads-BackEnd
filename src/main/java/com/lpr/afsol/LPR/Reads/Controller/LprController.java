package com.lpr.afsol.LPR.Reads.Controller;

import com.lpr.afsol.LPR.Reads.Entity.Images;
import com.lpr.afsol.LPR.Reads.Entity.LPR;
import com.lpr.afsol.LPR.Reads.Factory.ImagesFactory;
import com.lpr.afsol.LPR.Reads.Service.LprService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("lprreads/lpr/")
@Slf4j
public class LprController {
    @Autowired
    private LprService SERVICE;

    @PostMapping(value = {"create"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<LPR> create(@RequestPart("lpr") LPR lpr, @RequestPart("imageFile") MultipartFile[] file, @RequestPart("vehicleId") String vehicleId){
        log.info(vehicleId);
        try{
            Set<Images> images = uploadImage(file, lpr);
            lpr.setLprImages(images);
            return ResponseEntity.ok(this.SERVICE.create(lpr, Long.parseLong(vehicleId)));
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<Images> uploadImage(MultipartFile[] multipartFiles, LPR lpr) throws IOException {
        Set<Images> images = new HashSet<>();

        for (MultipartFile file: multipartFiles){
            Images img = ImagesFactory.buildImage(file.getOriginalFilename(), file.getContentType(), file.getBytes(), lpr);
            images.add(img);
        }
        return images;
    }

    @GetMapping("read/{id}")
    public ResponseEntity<LPR> read(@PathVariable long id){
        return ResponseEntity.ok(this.SERVICE.read(id));
    }

    @PutMapping(value = {"update"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<LPR> update(@RequestPart("lpr") LPR lpr, @RequestPart("imageFile") MultipartFile[] file){
        try{
            Set<Images> images = uploadImage(file, lpr);
            lpr.setLprImages(images);
            return ResponseEntity.ok(this.SERVICE.update(lpr));
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

//    @GetMapping("findLprByNumberPlate/{numberPlate}")
//    public ResponseEntity<List<LPR>> findLprByNumberPlate(@PathVariable String numberPlate){
//        return ResponseEntity.ok(this.SERVICE.findLprByNumberPlate(numberPlate));
//    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable long id){
        this.SERVICE.delete(id);
    }

//    @DeleteMapping("delete/{numberPlate}")
//    public void deleteLprByNumberPlate(@PathVariable String numberPlate){
//        this.SERVICE.deleteLprByNumberPlate(numberPlate);
//    }

    @GetMapping("getAll")
    public ResponseEntity<List<LPR>> getAll(){
        return ResponseEntity.ok(this.SERVICE.getAll());
    }
}
