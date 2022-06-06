package com.example.androidsoa.Principal;

public class PrincipalModel implements IPrincipal.Model {
    private IPrincipal.Presenter presenter;

    public PrincipalModel(IPrincipal.Presenter presenter) {
        this.presenter = presenter;
    }
}
