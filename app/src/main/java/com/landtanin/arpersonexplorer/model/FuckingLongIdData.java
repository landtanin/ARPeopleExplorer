package com.landtanin.arpersonexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tanin on 11/03/2018.
 */

public class FuckingLongIdData {

    @SerializedName("matched_face")
    @Expose
    private MatchedFaceData matchedFaceData;
    @SerializedName("person")
    @Expose
    private Person person;
    @SerializedName("metadata")
    @Expose
    private MetaData metaData;

}
