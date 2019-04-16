package com.bielma.arbosch.Modelos;

public class Credenciales {
    String logonId;
    String logonPassword;
    public Credenciales(String logonId, String logonPassword) {
        this.logonId = logonId;
        this.logonPassword = logonPassword;
    }

    public String getLogonId() {
        return logonId;
    }

    public void setLogonId(String logonId) {
        this.logonId = logonId;
    }

    public String getLogonPassword() {
        return logonPassword;
    }

    public void setLogonPassword(String logonPassword) {
        this.logonPassword = logonPassword;
    }


}
