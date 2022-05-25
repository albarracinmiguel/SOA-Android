package com.example.androidsoa.Signup;

import android.view.View;

import com.example.androidsoa.Services.SoaRequest;

public interface ISignup {
    interface View{
        void moveToLogin(android.view.View view);
        void signupSuccess();
        void signupFail();
        void register(android.view.View view);
    }
    interface Presenter{
        void registerUser(SoaRequest soaRequest);
    }
    interface Model{

    }
}
