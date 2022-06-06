package com.example.androidsoa.Signup;

import com.example.androidsoa.data.MyDatabase;
import com.example.androidsoa.network.SOAService.Request.SOARegisterRequest;

import java.util.List;

public class SignupModel implements ISignup.Model {
    private ISignup.Presenter presenter;
    private MyDatabase database;

    public SignupModel(ISignup.Presenter presenter, MyDatabase database) {
        this.presenter = presenter;
        this.database = database;
    }

    @Override
    public void addUser(SOARegisterRequest contact, String userName, String secret) {
        database.addSoaUser(contact, userName, secret);
    }

    @Override
    public void addContact(SOARegisterRequest contact) {
        database.addContact(contact);
    }

    @Override
    public List<SOARegisterRequest> getAllContacts() {
        return database.getAllContacts();
    }
}
