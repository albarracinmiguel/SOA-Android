package com.example.androidsoa;

public interface ILogin {
    interface View{
        void showResult(String result);
    }
    interface Presenter{
        void showResult(boolean result);
        void checkUser(String username, String password);
    }
    interface Model{
        void checkUser(String username, String password);
    }
}
