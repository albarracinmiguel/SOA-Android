package com.example.androidsoa.Principal;

import com.example.androidsoa.network.PokemonService.PokemonApi;
import com.example.androidsoa.util.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrincipalPresenter implements IPrincipal.Presenter {
    private IPrincipal.View view;
    private IPrincipal.Model model;
    private final PokemonApi pokemonApi;

    public PrincipalPresenter(IPrincipal.View view, PokemonApi pokemonApi) {
        this.view = view;
        this.pokemonApi = pokemonApi;
        this.model = new PrincipalModel(this);
    }

    public void getRandomPokemon() {
        System.out.println("------------ RANDOM POKEMON PRESENTER -------------------");
        int pokemonId = (int) (Math.random() * (Constants.MAX_POKEMON_ID + Constants.MIN_POKEMON_ID));
        System.out.println("Pokemon ID:" + pokemonId);
    }
}
