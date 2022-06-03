package com.example.androidsoa.Principal;

import com.example.androidsoa.network.PokemonService.PokemonResponse;

public interface IPrincipal {
    interface View {
        void showPokemon(PokemonResponse pokemonResponse);
    }

    interface Presenter {
        void getRandomPokemon();
    }

    interface Model {
    }
}
