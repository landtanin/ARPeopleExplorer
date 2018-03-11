package com.landtanin.arpersonexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tanin on 11/03/2018.
 */

public class Face {

    @SerializedName("matched_face")
    @Expose
    private MatchedFaceData matchedFaceData;
    @SerializedName("person")
    @Expose
    private Person person;
    @SerializedName("metadata")
    @Expose
    private MetaData metaData;

    public MatchedFaceData getMatchedFaceData() {
        return matchedFaceData;
    }

    public void setMatchedFaceData(MatchedFaceData matchedFaceData) {
        this.matchedFaceData = matchedFaceData;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }
}
