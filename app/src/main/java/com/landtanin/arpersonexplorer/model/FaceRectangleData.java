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

}
