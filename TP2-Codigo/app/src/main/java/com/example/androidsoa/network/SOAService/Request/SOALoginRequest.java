package com.example.androidsoa.network.SOAService.Request;

import com.google.gson.annotations.SerializedName;

public class SOALoginRequest {
    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public SOALoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
