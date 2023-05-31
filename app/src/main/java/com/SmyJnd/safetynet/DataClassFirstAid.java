package com.SmyJnd.safetynet;


public class DataClassFirstAid {

    private String dataTitle;
    private int dataDesc;
     private int dataImage;

    public String getDataTitle() {
        return dataTitle;
    }

    public int getDataDesc() {
        return dataDesc;
    }

    public int getDataImage() {
        return dataImage;
    }

    public DataClassFirstAid(String dataTitle, int dataDesc, int dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataImage = dataImage;
    }
}