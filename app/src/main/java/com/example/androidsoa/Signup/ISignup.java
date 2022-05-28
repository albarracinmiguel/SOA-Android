package com.example.androidsoa.Signup;

import com.example.androidsoa.network.SOAService.SOARequest;

import java.util.List;

public interface ISignup {
    interface View{
        void moveToLogin(android.view.View view);
        void signupSuccess();
        void signupFail();
        void register(android.view.View view);
    }
    interface Presenter{
        void registerUser(SOARequest soaRequest);
        void getList();
    }

    interface Model{
        void addContact(SOARequest contact);
        List<SOARequest> getAllContacts();
    }
}
