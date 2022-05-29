package com.example.androidsoa.network.PokemonService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApi {

    @GET("https://pokeapi.co/api/v2/pokedex/{identifier}")
    Call<PokemonResponse> getRandom(@Path("identifier") String identifier);
}
