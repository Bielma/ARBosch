package com.bielma.arbosch.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Producto {
    //String aber;
    @SerializedName("uniqueID")
    @Expose
    String uniqueID;
    @SerializedName("fullImage")
    @Expose
    String fullImage;
    @SerializedName("thumbnail")
    @Expose
    String thumbnail;
    @SerializedName("shortDescription")
    @Expose
    String shortDescription;
    @SerializedName("priceINMXN")
    @Expose
    String priceINMXN;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("longDescription")
    @Expose
    String longDescription;


    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getFullImage() {
        return fullImage;
    }

    public void setFullImage(String fullImage) {
        this.fullImage = fullImage;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPriceINMXN() {
        return priceINMXN;
    }

    public void setPriceINMXN(String priceINMXN) {
        this.priceINMXN = priceINMXN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

}
