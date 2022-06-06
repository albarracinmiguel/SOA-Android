package com.example.androidsoa.Principal;

import android.view.View;

import com.example.androidsoa.network.PokemonService.PokemonResponse;

public interface IPrincipal {
    interface View {
        void showPokemon(PokemonResponse pokemonResponse);
        void goToHistoy(android.view.View view);
    }

    interface Presenter {
        void getRandomPokemon();

        void getTypedPokemon(String type);
    }

    interface Model {
    }
}
