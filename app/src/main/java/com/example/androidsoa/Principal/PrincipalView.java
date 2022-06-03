package com.example.androidsoa.Principal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidsoa.R;
import com.example.androidsoa.network.PokemonService.PokemonApi;
import com.example.androidsoa.network.PokemonService.PokemonResponse;
import com.example.androidsoa.network.PokemonService.PokemonTypeResponse;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class PrincipalView extends DaggerAppCompatActivity implements IPrincipal.View {
    private TextView name;
    private TextView type;
    private ImageView frontImage;
    private ImageView backImage;

    private IPrincipal.Presenter presenter;

    @Inject
    PokemonApi pokemonApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        presenter = new PrincipalPresenter(this, pokemonApi);
        name = (TextView) findViewById(R.id.PokemonNameTxt);
        type = (TextView) findViewById(R.id.PokemonTypeTxt);
        frontImage = (ImageView) findViewById(R.id.PokemonFrontImg);
        backImage = (ImageView) findViewById(R.id.pokemonBackImg);

        presenter.getRandomPokemon();
    }

    public void getRandomPokemon(View view) {
        presenter.getRandomPokemon();
    }

    public void showPokemon(PokemonResponse pokemonResponse) {
        StringBuilder types = new StringBuilder();
        name.setText(pokemonResponse.getName().toUpperCase());

        for (PokemonTypeResponse pokemonTypeResponse : pokemonResponse.getTypes()) {
            types.append(pokemonTypeResponse.getType().getName().toUpperCase());
            types.append(" ");
        }

        type.setText(types);

        Picasso.get().load(pokemonResponse.getSprites().getFrontDefault()).into(frontImage);
        Picasso.get().load(pokemonResponse.getSprites().getBackDefault()).into(backImage);
    }
}