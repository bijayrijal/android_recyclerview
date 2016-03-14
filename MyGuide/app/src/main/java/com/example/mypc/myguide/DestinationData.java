package com.example.mypc.myguide;

/**
 * Created by my pc on 3/12/2016.
 */
public class DestinationData {

    int imageId;
    String destinationName,description;

    public DestinationData(int imageId, String destinationName, String description) {
        this.imageId = imageId;
        this.destinationName = destinationName;
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
