package com.example.androidsoa.Principal;

public class PrincipalPresenter implements IPrincipal.Presenter{
    private IPrincipal.View view;
    private IPrincipal.Model model;

    public PrincipalPresenter(IPrincipal.View view){
        this.view = view;
        this.model = new PrincipalModel(this);

    }
}
