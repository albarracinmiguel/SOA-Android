package com.example.androidsoa.Signup;

import com.example.androidsoa.Services.SoaRequest;

import java.util.List;

public interface ISignup {
    interface View{
        void moveToLogin(android.view.View view);
        void signupSuccess();
        void signupFail();
        void register(android.view.View view);
    }
    interface Presenter{
        void registerUser(SoaRequest soaRequest);
        void getList();
    }
    interface Model{

    }
    interface Repository{
        void addContact(SoaRequest contact);
        List<SoaRequest> getAllContacts();
    }
}
