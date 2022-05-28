package com.example.androidsoa.network.SOAService;
import  com.google.gson.annotations.SerializedName;
public class SOAResponse {
    private Boolean success;
    private String env;
    private String token;
    private String token_refresh;

    // getters
    public Boolean getSuccess() {
        return success;
    }
    public String getEnv() {
        return env;
    }
    public String getToken() {
        return token;
    }
    public String getToken_refresh() {
        return token_refresh;
    }

    // setters
    public void setEnv(String env) {
        this.env = env;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public void setToken_refresh(String token_refresh) {
        this.token_refresh = token_refresh;
    }
}
