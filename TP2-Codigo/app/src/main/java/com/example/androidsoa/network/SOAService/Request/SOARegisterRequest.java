package com.example.androidsoa.network.SOAService.Request;

import com.google.gson.annotations.SerializedName;

public class SOARegisterRequest {
    @SerializedName("env")
    private String env;
    @SerializedName("name")
    private String name;
    @SerializedName("lastname")
    private String lastname;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("dni")
    private long dni;
    @SerializedName("commission")
    private long commission;
    @SerializedName("group")
    private long group;

    public SOARegisterRequest() {
    }

    public SOARegisterRequest(String env, String name, String lastname, String email, String password, long dni, long commission, long group) {
        this.env = env;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.dni = dni;
        this.commission = commission;
        this.group = group;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public long getCommission() {
        return commission;
    }

    public void setCommission(long commission) {
        this.commission = commission;
    }

    public long getGroup() {
        return group;
    }

    public void setGroup(long group) {
        this.group = group;
    }
}
