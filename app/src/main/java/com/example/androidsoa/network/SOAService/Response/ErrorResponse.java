package com.example.androidsoa.network.SOAService.Response;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {
    @SerializedName("success")
    private Boolean success;

    @SerializedName("env")
    private String env;

    @SerializedName("msg")
    private String msg;

    public ErrorResponse(Boolean success, String env, String msg) {
        this.success = success;
        this.env = env;
        this.msg = msg;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
