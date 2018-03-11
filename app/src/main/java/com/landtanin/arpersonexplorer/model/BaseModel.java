package com.landtanin.arpersonexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tanin on 10/03/2018.
 */

public class BaseModel {

    @SerializedName("116ba9cb-7b89-489f-88e4-a71cc621de90")
    @Expose
    private FuckingLongIdData fuckingLongIdData;

    public FuckingLongIdData getFuckingLongIdData() {
        return fuckingLongIdData;
    }

    public void setFuckingLongIdData(FuckingLongIdData fuckingLongIdData) {
        this.fuckingLongIdData = fuckingLongIdData;
    }
}
