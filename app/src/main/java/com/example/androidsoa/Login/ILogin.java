package com.example.androidsoa.Login;

import android.view.View;

public interface ILogin {
    interface View{
        void showResult(String result);
        void moveToPrincipal();
        void moveToSignup(android.view.View view);
    }
    interface Presenter{
        void showResult(boolean result);
        void checkUser(String username, String password);
    }
    interface Model{
        void checkUser(String username, String password);
    }
}
