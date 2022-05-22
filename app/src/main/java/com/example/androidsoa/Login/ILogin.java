package com.example.androidsoa.Login;

public interface ILogin {
    interface View{
        void showResult(String result);
        void moveToPrincipal();
    }
    interface Presenter{
        void showResult(boolean result);
        void checkUser(String username, String password);
    }
    interface Model{
        void checkUser(String username, String password);
    }
}
