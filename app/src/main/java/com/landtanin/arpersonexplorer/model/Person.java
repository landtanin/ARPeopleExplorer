package com.landtanin.arpersonexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tanin on 11/03/2018.
 */

public class Person {

    @SerializedName("personId")
    @Expose
    private String personIdStr;
    @SerializedName("persistedFaceIds")
    @Expose
    private List<String> persistedFaceIdsStr;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("userData")
    @Expose
    private String userData;

    public String getPersonIdStr() {
        return personIdStr;
    }

    public void setPersonIdStr(String personIdStr) {
        this.personIdStr = personIdStr;
    }

    public List<String> getPersistedFaceIdsStr() {
        return persistedFaceIdsStr;
    }

    public void setPersistedFaceIdsStr(List<String> persistedFaceIdsStr) {
        this.persistedFaceIdsStr = persistedFaceIdsStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }
}
