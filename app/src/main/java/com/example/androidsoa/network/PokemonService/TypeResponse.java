package com.example.androidsoa.network.PokemonService;

import com.google.gson.annotations.SerializedName;

public class TypeResponse {
    @SerializedName("name")
    private String name;

    public TypeResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
