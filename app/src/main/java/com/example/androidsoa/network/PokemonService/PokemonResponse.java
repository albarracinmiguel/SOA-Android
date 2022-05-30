package com.example.androidsoa.network.PokemonService;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class PokemonResponse {
    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    public PokemonResponse() {
    }

    public PokemonResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
