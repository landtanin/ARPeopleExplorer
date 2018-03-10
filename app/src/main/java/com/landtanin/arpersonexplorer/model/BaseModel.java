package com.landtanin.arpersonexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tanin on 10/03/2018.
 */

public class BaseModel {

    @SerializedName("b64img")
    @Expose
    private String b64img;

    public String getB64img() {
        return b64img;
    }

    public void setB64img(String b64img) {
        this.b64img = b64img;
    }
}
