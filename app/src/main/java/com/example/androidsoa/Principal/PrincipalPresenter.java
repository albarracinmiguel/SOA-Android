package com.example.androidsoa.Principal;

import android.util.Log;

import com.example.androidsoa.network.PokemonService.PokemonApi;
import com.example.androidsoa.network.PokemonService.PokemonResponse;
import com.example.androidsoa.util.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrincipalPresenter implements IPrincipal.Presenter {
    private IPrincipal.View view;
    private IPrincipal.Model model;
    private final PokemonApi pokemonApi;
    private static String TAG = PrincipalPresenter.class.getName();

    public PrincipalPresenter(IPrincipal.View view, PokemonApi pokemonApi) {
        this.view = view;
        this.pokemonApi = pokemonApi;
        this.model = new PrincipalModel(this);
    }

    public void getRandomPokemon() {
        int pokemonId = (int) (Math.random() * (Constants.MAX_POKEMON_ID + Constants.MIN_POKEMON_ID));

        pokemonApi.getRandom(Integer.toString(pokemonId));
        Call<PokemonResponse> call = pokemonApi.getRandom(Integer.toString(pokemonId));
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    PokemonResponse pokemonResponse = response.body();
                    view.showPokemon(pokemonResponse);
                } else {
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
