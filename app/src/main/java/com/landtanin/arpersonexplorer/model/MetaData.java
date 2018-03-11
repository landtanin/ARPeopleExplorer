package com.landtanin.arpersonexplorer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tanin on 10/03/2018.
 */

public class MetaData {

    @SerializedName("id")
    @Expose
    private String idStr;
    @SerializedName("twitter")
    @Expose
    private String twitterSr;
    @SerializedName("face")
    @Expose
    private String faceSr;
    @SerializedName("name")
    @Expose
    private String nameSr;
    @SerializedName("website")
    @Expose
    private String websiteSr;
    @SerializedName("linkedin")
    @Expose
    private String linkedinSr;
    @SerializedName("bio")
    @Expose
    private String bioSr;

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getTwitterSr() {
        return twitterSr;
    }

    public void setTwitterSr(String twitterSr) {
        this.twitterSr = twitterSr;
    }

    public String getFaceSr() {
        return faceSr;
    }

    public void setFaceSr(String faceSr) {
        this.faceSr = faceSr;
    }

    public String getNameSr() {
        return nameSr;
    }

    public void setNameSr(String nameSr) {
        this.nameSr = nameSr;
    }

    public String getWebsiteSr() {
        return websiteSr;
    }

    public void setWebsiteSr(String websiteSr) {
        this.websiteSr = websiteSr;
    }

    public String getLinkedinSr() {
        return linkedinSr;
    }

    public void setLinkedinSr(String linkedinSr) {
        this.linkedinSr = linkedinSr;
    }

    public String getBioSr() {
        return bioSr;
    }

    public void setBioSr(String bioSr) {
        this.bioSr = bioSr;
    }
}
