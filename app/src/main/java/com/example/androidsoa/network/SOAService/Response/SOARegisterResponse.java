package com.example.androidsoa.network.SOAService.Response;

import com.google.gson.annotations.SerializedName;

public class SOARegisterResponse {
    @SerializedName("success")
    private Boolean success;

    @SerializedName("env")
    private String env;

    @SerializedName("token")
    private String token;

    @SerializedName("token_refresh")
    private String tokenRefresh;

    public SOARegisterResponse(Boolean success, String env, String token, String tokenRefresh) {
        this.success = success;
        this.env = env;
        this.token = token;
        this.tokenRefresh = tokenRefresh;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenRefresh() {
        return tokenRefresh;
    }

    public void setTokenRefresh(String tokenRefresh) {
        this.tokenRefresh = tokenRefresh;
    }
}
