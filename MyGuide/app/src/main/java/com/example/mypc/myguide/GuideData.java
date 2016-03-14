package com.example.mypc.myguide;

/**
 * Created by my pc on 3/9/2016.
 */
public class GuideData {

    int imageId;
    String guideName,email,mobileNumber;

    public GuideData(int imageId, String guideName, String email, String mobileNumber) {
        this.imageId = imageId;
        this.guideName = guideName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
