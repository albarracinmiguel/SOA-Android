package com.example.androidsoa.Signup;

public class SignupModel implements ISignup.Model {
    private ISignup.Presenter presenter;
    public SignupModel(ISignup.Presenter presenter){
        this.presenter = presenter;
    }
}
