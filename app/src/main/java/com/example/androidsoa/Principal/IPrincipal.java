package com.example.androidsoa.Principal;

public interface IPrincipal {
    interface View {
    }

    interface Presenter {
        void getRandomPokemon();
    }

    interface Model {

        void getRandomPokemon();

        void getPokemon(String identifier);
    }
}
