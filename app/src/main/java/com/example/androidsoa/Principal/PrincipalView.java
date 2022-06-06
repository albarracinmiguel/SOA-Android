package com.example.androidsoa.Principal;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.androidsoa.History.HistoryView;
import com.example.androidsoa.Login.LoginView;
import com.example.androidsoa.R;
import com.example.androidsoa.network.PokemonService.PokemonApi;
import com.example.androidsoa.network.PokemonService.PokemonResponse;
import com.example.androidsoa.network.PokemonService.PokemonTypeResponse;
import com.example.androidsoa.sensors.ShakeService;
import com.example.androidsoa.sensors.TemperatureService;
import com.example.androidsoa.util.Constants;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class PrincipalView extends DaggerAppCompatActivity implements IPrincipal.View {
    private TextView name;
    private TextView type;
    private ImageView frontImage;
    private ImageView backImage;
    private boolean isHot = false;
    private static final String TAG = PrincipalView.class.getName();


    private IPrincipal.Presenter presenter;

    @Inject
    PokemonApi pokemonApi;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        presenter = new PrincipalPresenter(this, pokemonApi);
        name = (TextView) findViewById(R.id.PokemonNameTxt);
        type = (TextView) findViewById(R.id.PokemonTypeTxt);
        frontImage = (ImageView) findViewById(R.id.PokemonFrontImg);
        backImage = (ImageView) findViewById(R.id.pokemonBackImg);

        Intent intentTemperatureService = new Intent(this, TemperatureService.class);
        startService(intentTemperatureService);
        TemperatureService mTemperatureDetector = new TemperatureService();
        mTemperatureDetector.setOnTemperatureListener((isHot) -> {
            this.isHot = isHot;
        });

        Intent intentShakeService = new Intent(this, ShakeService.class);
        startService(intentShakeService);
        ShakeService mShakeDetector = new ShakeService();
        mShakeDetector.setOnShakeListener(() -> {
            if (isHot) {
                presenter.getTypedPokemon(Constants.FIRE_TYPE);
            } else {
                presenter.getTypedPokemon(Constants.ICE_TYPE);
            }
        });


    }

    public void getRandomPokemon(View view) {
        presenter.getRandomPokemon();
    }

    public void goToHistoy(View view) {
        startActivity(new Intent(PrincipalView.this, HistoryView.class));
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