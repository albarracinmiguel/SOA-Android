package com.example.androidsoa.pokemon;

public interface IPokemonClient {
    void getPokemon(String name);

    void sendRequest(String identifier) throws Exception;
}
