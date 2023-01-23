package com.lpr.afsol.LPR.Reads.Repository;

import com.lpr.afsol.LPR.Reads.Entity.Images;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Images, Long> {
}
