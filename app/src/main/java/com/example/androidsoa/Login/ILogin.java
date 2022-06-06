package com.example.androidsoa.Login;

import android.view.View;

public interface ILogin {
    interface View{
        void login(android.view.View view);
        void showError(String result);
        void showOTP();
        void moveToPrincipal();
        void moveToSignup(android.view.View view);
        void loginOTP(android.view.View view);
    }
    interface Presenter{
        void showResult(boolean result);
        void showOTP();
        void checkUser(String username, String password);
        void checkValidOTP(String otp);
    }
    interface Model{
        void checkUser(String username, String password);
        boolean checkOtp(String otp);
    }
}
