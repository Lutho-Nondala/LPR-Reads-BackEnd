package com.lpr.afsol.LPR.Reads.Entity;

import jakarta.persistence.*;

@Entity
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String type;
    @Column(length = 50000000)
    private byte[] imgByte;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lpr_id", referencedColumnName = "id")
    private LPR lpr;

    public Images(){

    }

    public Images(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.imgByte = builder.imgByte;
        this.lpr = builder.lpr;
    }

    public LPR getLpr() {
        return lpr;
    }

    public void setLpr(LPR lpr) {
        this.lpr = lpr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImgByte() {
        return imgByte;
    }

    public void setImgByte(byte[] imgByte) {
        this.imgByte = imgByte;
    }

    public static class Builder{
        private long id;
        private String name, type;
        private byte[] imgByte;

        private LPR lpr;

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder type(String type){
            this.type = type;
            return this;
        }

        public Builder imgByte(byte[] imgByte){
            this.imgByte = imgByte;
            return this;
        }

        public Builder lpr(LPR lpr){
            this.lpr = lpr;
            return this;
        }

        public Builder copy(Images images){
            this.id = images.id;
            this.name = images.name;
            this.type = images.type;
            this.imgByte = images.imgByte;
            this.lpr = images.lpr;
            return this;
        }

        public Images build(){
            return new Images(this);
        }
    }
}
