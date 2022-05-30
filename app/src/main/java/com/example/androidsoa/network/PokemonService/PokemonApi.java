package com.example.androidsoa.network.PokemonService;

import com.example.androidsoa.util.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApi {

    @GET(Constants.POKEMON_API)
    Call<PokemonResponse> getRandom(@Path("identifier") String identifier);
}
