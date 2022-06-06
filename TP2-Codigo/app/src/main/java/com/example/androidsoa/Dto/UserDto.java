package com.example.androidsoa.Dto;

public class UserDto {
    private String name;
    private String lastName;
    private long dni;
    private long commission;
    private long group;
    private String email;
    private String userName;
    private String password;

    public UserDto(String name, String lastName, long dni, long commission, long group, String email, String userName, String password) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.commission = commission;
        this.group = group;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
