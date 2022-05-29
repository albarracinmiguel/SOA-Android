package com.example.androidsoa.pokemon;

import java.io.IOException;

public interface IPokemonClient {
    void getPokemon(String name);

    void sendRequest(String identifier) throws Exception;
}
