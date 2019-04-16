package com.bielma.arbosch.Modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tokens {
    @SerializedName("WCToken")
    @Expose
    private String wCToken;
    @SerializedName("WCTrustedToken")
    @Expose
    private String wCTrustedToken;



    public String getWCTrustedToken() {
        return wCTrustedToken;
    }

    public void setWCTrustedToken(String WCTrustedToken) {
        this.wCTrustedToken = WCTrustedToken;
    }

    public String getWCToken() {
        return wCToken;
    }

    public void setWCToken(String WCToken) {
        this.wCToken = WCToken;
    }
}
