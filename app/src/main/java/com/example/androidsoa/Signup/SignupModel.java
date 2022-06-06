package com.example.androidsoa.Signup;

import com.example.androidsoa.network.SOAService.SOARequest;
import com.example.androidsoa.data.MyDatabase;

import java.util.List;

public class SignupModel implements ISignup.Model {
    private ISignup.Presenter presenter;
    private MyDatabase database;

    public SignupModel(ISignup.Presenter presenter, MyDatabase database){
        this.presenter = presenter;
        this.database = database;
    }

    @Override
    public void addUser(SOARequest contact, String secret) {
        database.addSoaUser(contact, secret);
    }

    @Override
    public void addContact(SOARequest contact) {
         database.addContact(contact);
    }

    @Override
    public List<SOARequest> getAllContacts() {
        return database.getAllContacts();
    }

    class UserModel{
        private String userName;
        private String password;
        private String email;
        private String name;
        private String lastName;
        private long dni;
        private long commission;
        private long group;

        public UserModel(String userName, String password, String email, String name, String lastName, long dni, long commission, long group) {
            this.userName = userName;
            this.password = password;
            this.email = email;
            this.name = name;
            this.lastName = lastName;
            this.dni = dni;
            this.commission = commission;
            this.group = group;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        public long getDni() {
            return dni;
        }

        public long getCommission() {
            return commission;
        }

        public long getGroup() {
            return group;
        }

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setDni(long dni) {
            this.dni = dni;
        }

        public void setCommission(long commission) {
            this.commission = commission;
        }

        public void setGroup(long group) {
            this.group = group;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
