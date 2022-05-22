package com.example.androidsoa;

public class LoginModel implements ILogin.Model{
    private ILogin.Presenter presenter;
    private boolean result;

    public LoginModel(ILogin.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void checkUser(String username, String password) {
        if(username.equals("rodri") && password.equals("123")){
            result = true;
        }
        else {
            result = false;
        }
        presenter.showResult(result);
    }
}
