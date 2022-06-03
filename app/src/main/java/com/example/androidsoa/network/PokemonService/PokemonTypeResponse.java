package com.example.androidsoa.network.PokemonService;

import com.google.gson.annotations.SerializedName;

public class PokemonTypeResponse {
    @SerializedName("type")
    private TypeResponse type;

    public PokemonTypeResponse(TypeResponse type) {
        this.type = type;
    }

    public TypeResponse getType() {
        return type;
    }

    public void setType(TypeResponse type) {
        this.type = type;
    }
}
