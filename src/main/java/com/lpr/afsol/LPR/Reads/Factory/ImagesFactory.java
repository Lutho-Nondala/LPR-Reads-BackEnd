package com.lpr.afsol.LPR.Reads.Factory;

import com.lpr.afsol.LPR.Reads.Entity.Images;
import com.lpr.afsol.LPR.Reads.Entity.LPR;

public class ImagesFactory {
    public static Images buildImage(String name, String type, byte[] imgByte, LPR lpr){
        if (name.isEmpty() || name == null){
            throw new IllegalArgumentException("Name is needed.");
        }
        if (type.isEmpty() || type == null){
            throw new IllegalArgumentException("Type is needed.");
        }
        if (imgByte.length == 0 || imgByte == null){
            throw new IllegalArgumentException("Bytes are needed.");
        }
        if (lpr == null){
            throw new IllegalArgumentException("lpr is needed");
        }

        return new Images.Builder().name(name).type(type).imgByte(imgByte).lpr(lpr).build();
    }
}
