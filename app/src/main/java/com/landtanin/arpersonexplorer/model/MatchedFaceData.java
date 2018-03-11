package com.landtanin.arpersonexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tanin on 11/03/2018.
 */

public class MatchedFaceData {

    @SerializedName("faceId")
    @Expose
    private String faceIdStr;
    @SerializedName("faceRectangle")
    @Expose
    private FaceRectangleData faceRectangleData;

    public String getFaceIdStr() {
        return faceIdStr;
    }

    public void setFaceIdStr(String faceIdStr) {
        this.faceIdStr = faceIdStr;
    }

    public FaceRectangleData getFaceRectangleData() {
        return faceRectangleData;
    }

    public void setFaceRectangleData(FaceRectangleData faceRectangleData) {
        this.faceRectangleData = faceRectangleData;
    }
}
