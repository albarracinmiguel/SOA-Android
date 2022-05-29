package com.example.androidsoa.Principal;

import com.example.androidsoa.pokemon.IPokemonClient;
import com.example.androidsoa.pokemon.PokemonClient;
import com.example.androidsoa.util.Constants;

public class PrincipalModel implements IPrincipal.Model {
    private IPrincipal.Presenter presenter;
    private IPokemonClient pokemonClient;

    public PrincipalModel(IPrincipal.Presenter presenter) {
        this.presenter = presenter;
        this.pokemonClient = new PokemonClient();
        this.presenter = presenter;
    }

    public void getRandomPokemon() {
        int pokemonId = (int) (Math.random() * (Constants.MAX_POKEMON_ID + Constants.MIN_POKEMON_ID));

        this.getPokemon(Integer.toString(pokemonId));
    }

    /* Se puede obtener por ID o NAME (Ej. 1 o Bulbasaur). */
    public void getPokemon(String identifier) {
        this.pokemonClient.getPokemon(identifier);
    }
}
