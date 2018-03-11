package com.landtanin.arpersonexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tanin on 10/03/2018.
 */

public class BaseModel {

    @SerializedName("373357db-bda9-4257-8677-7ca2331a6449")
    @Expose
    private FuckingLongIdData fuckingLongIdData;

    public FuckingLongIdData getFuckingLongIdData() {
        return fuckingLongIdData;
    }

    public void setFuckingLongIdData(FuckingLongIdData fuckingLongIdData) {
        this.fuckingLongIdData = fuckingLongIdData;
    }
}
