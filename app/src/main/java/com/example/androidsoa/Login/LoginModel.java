package com.example.androidsoa.Login;

public class LoginModel implements ILogin.Model{
    private ILogin.Presenter presenter;
    private boolean result;

    public LoginModel(ILogin.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void checkUser(String username, String password) {
        result = username.equals("rodri") && password.equals("123");
        presenter.showResult(result);
    }
}
