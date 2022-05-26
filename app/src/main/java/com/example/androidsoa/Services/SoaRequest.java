package com.example.androidsoa.Services;

import com.google.gson.annotations.SerializedName;

public class SoaRequest {
    @SerializedName("env")
    private String env;
    @SerializedName("name")
    private String name;
    @SerializedName("lastName")
    private String lastName;
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

    // getters
    public String getEnv() { return env; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public long getDni() { return dni; }
    public long getCommission() { return commission; }
    public long getGroup() { return group; }

    // setters
    public void setEnv(String env) { this.env = env; }
    public void setName(String name) { this.name = name; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setDni(long din) { this.dni = dni; }
    public void setComission(long comission) { this.commission = commission; }
    public void setGroup(long group) { this.group = group; }

    public SoaRequest(String name, String lastName, String email, String password, String dni, String commission, String group){
        this.env = "TEST";
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        if(!dni.equals(""))
            this.dni = Long.parseLong(dni);
        if(!commission.equals(""))
            this.commission = Long.parseLong(commission);
        if(!group.equals(""))
            this.group = Long.parseLong(group);
    }
    public SoaRequest(){};
}
