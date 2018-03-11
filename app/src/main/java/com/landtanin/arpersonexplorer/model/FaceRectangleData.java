package com.landtanin.arpersonexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tanin on 11/03/2018.
 */

public class FaceRectangleData {

    @SerializedName("top")
    @Expose
    private String topStr;
    @SerializedName("left")
    @Expose
    private String leftStr;
    @SerializedName("width")
    @Expose
    private String widthStr;
    @SerializedName("height")
    @Expose
    private String heightStr;

    public String getTopStr() {
        return topStr;
    }

    public void setTopStr(String topStr) {
        this.topStr = topStr;
    }

    public String getLeftStr() {
        return leftStr;
    }

    public void setLeftStr(String leftStr) {
        this.leftStr = leftStr;
    }

    public String getWidthStr() {
        return widthStr;
    }

    public void setWidthStr(String widthStr) {
        this.widthStr = widthStr;
    }

    public String getHeightStr() {
        return heightStr;
    }

    public void setHeightStr(String heightStr) {
        this.heightStr = heightStr;
    }
}
