package com.example.androidsoa.Login;

import com.example.androidsoa.util.ErrorConstants;

public class LoginPresenter implements ILogin.Presenter {

    private ILogin.View view;
    private ILogin.Model model;

    public LoginPresenter(ILogin.View view) {
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public void showResult(boolean result) {
        if (view != null) {
            if (result) {
                view.moveToPrincipal();
            } else {
                view.showResult(ErrorConstants.INVALID_LOGIN);
            }
        }
    }

    @Override
    public void checkUser(String username, String password) {
        if (view != null) {
            model.checkUser(username, password);
        }
    }
}
