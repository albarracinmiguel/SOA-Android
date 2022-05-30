package com.example.androidsoa.Principal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androidsoa.R;
import com.example.androidsoa.network.PokemonService.PokemonApi;
import com.example.androidsoa.network.PokemonService.PokemonResponse;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class PrincipalView extends DaggerAppCompatActivity implements IPrincipal.View {
    private TextView name;

    private IPrincipal.Presenter presenter;

    @Inject
    PokemonApi pokemonApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        presenter = new PrincipalPresenter(this, pokemonApi);
        name = (TextView)findViewById(R.id.PokemonNameTxt);
    }

    public void getRandomPokemon(View view) {
        presenter.getRandomPokemon();
    }

    public void showPokemon(PokemonResponse pokemonResponse)
    {
        name.setText(pokemonResponse.getName());
    }
}