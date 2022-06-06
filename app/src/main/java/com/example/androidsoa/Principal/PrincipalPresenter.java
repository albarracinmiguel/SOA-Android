package com.example.androidsoa.Principal;

import android.util.Log;

import com.example.androidsoa.network.PokemonService.PokemonApi;
import com.example.androidsoa.network.PokemonService.PokemonApiResponse;
import com.example.androidsoa.network.PokemonService.PokemonResponse;
import com.example.androidsoa.network.PokemonService.TypeApiResponse;
import com.example.androidsoa.util.Constants;

import java.io.IOException;

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

        pokemonApi.getPokemon(Integer.toString(pokemonId));
        Call<PokemonResponse> call = pokemonApi.getPokemon(Integer.toString(pokemonId));
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
                if (t instanceof IOException)
                    Log.e(TAG, "this is an actual network failure :( inform the user and possibly retry");
                else
                    Log.e(TAG, t.getMessage());
            }
        });
    }


    public void getTypedPokemon(String type) {
        Call<TypeApiResponse> call = pokemonApi.getRandomTypeData(type);
        call.enqueue(new Callback<TypeApiResponse>() {
            @Override
            public void onResponse(Call<TypeApiResponse> call, Response<TypeApiResponse> response) {
                if (response.isSuccessful()) {
                    TypeApiResponse pokemonFireResponse = response.body();
                    int randomArrayPosition = (int) (Math.random() * (0 + pokemonFireResponse.pokemon.length));
                    String pokemonUrl = pokemonFireResponse.pokemon[randomArrayPosition].pokemon.url;
                    String[] urlParams = pokemonUrl.split("/");
                    Call<PokemonResponse> callGetPokemon = pokemonApi.getPokemon(urlParams[urlParams.length-1]);
                    callGetPokemon.enqueue(new Callback<PokemonResponse>() {
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
                            // logging internet issue
                            if (t instanceof IOException) {
                                Log.e(TAG, "this is an actual network failure :( inform the user and possibly retry");
                            }
                            else
                                Log.e(TAG, t.getMessage());
                        }
                    });
                } else {
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(Call<TypeApiResponse> call, Throwable t) {
                if (t instanceof IOException) {
                    Log.e(TAG, "this is an actual network failure :( inform the user and possibly retry");
                }
                else
                    Log.e(TAG, t.getMessage());
            }
        });
    }
}
