package com.SmyJnd.safetynet;

public class DataClass {

    private String dataTitle;
    private int dataImage;
    private String dataNo;


    public String getDataTitle() {
        return dataTitle;
    }

    public int getDataImage() {
        return dataImage;
    }

    public String getDataNo() {
        return dataNo;
    }

    public DataClass(String dataTitle, int dataImage, String dataNo) {
        this.dataTitle = dataTitle;
        this.dataImage = dataImage;
        this.dataNo = dataNo;
    }
}
