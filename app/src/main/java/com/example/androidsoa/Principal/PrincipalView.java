package com.example.androidsoa.Principal;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidsoa.R;

public class PrincipalView extends AppCompatActivity implements IPrincipal.View {
    private IPrincipal.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        presenter = new PrincipalPresenter(this);
        System.out.println("------------ PRINCIPAL VIEW -------------------");
    }

    public void getRandomPokemon(View view) {
        System.out.println("------------ RANDOM POKEMON VIEW -------------------");
        presenter.getRandomPokemon();
        System.out.print("Request to Pokemon API");
    }
}