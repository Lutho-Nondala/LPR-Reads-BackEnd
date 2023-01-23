package com.lpr.afsol.LPR.Reads.Service;

import com.lpr.afsol.LPR.Reads.Entity.Images;
import com.lpr.afsol.LPR.Reads.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagesService {
    @Autowired
    private ImageRepository REPOSITORY;

    public Images create(Images images){
        return this.REPOSITORY.save(images);
    }
}
