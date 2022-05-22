package com.example.androidsoa;

public class LoginPresenter implements ILogin.Presenter{

    private ILogin.View view;
    private ILogin.Model model;

    public LoginPresenter(ILogin.View view){
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public void showResult(boolean result) {
        if(view != null){
            if(result){
                view.showResult("Usuario Valido");
            }
            else{
                view.showResult("Usuario Invalido");
            }
        }
    }

    @Override
    public void checkUser(String username, String password) {
        if(view != null){
            model.checkUser(username, password);
        }
    }
}
