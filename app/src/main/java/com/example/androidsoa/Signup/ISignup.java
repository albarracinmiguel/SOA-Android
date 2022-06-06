package com.example.androidsoa.Signup;

import com.example.androidsoa.network.SOAService.Request.SOARegisterRequest;

import java.util.List;

public interface ISignup {
    interface View{
        void moveToLogin(android.view.View view);
        void signupSuccess(String secret);
        void signupFail();
        void register(android.view.View view);
    }
    interface Presenter{
        void registerUser(SOARegisterRequest soaRequest);
        void getList();
    }

    interface Model{
        void addUser(SOARegisterRequest contact, String secret);
        void addContact(SOARegisterRequest contact);
        List<SOARegisterRequest> getAllContacts();
    }
}
