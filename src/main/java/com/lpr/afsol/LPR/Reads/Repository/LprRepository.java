package com.lpr.afsol.LPR.Reads.Repository;

import com.lpr.afsol.LPR.Reads.Entity.LPR;
import com.lpr.afsol.LPR.Reads.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LprRepository extends JpaRepository<LPR, Long> {
//    List<LPR> findLprByNumberPlate(String numberPlate);
//
//    void deleteLprByNumberPlate(String numberPlate);
}
