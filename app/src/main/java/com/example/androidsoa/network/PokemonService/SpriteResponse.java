package com.example.androidsoa.network.PokemonService;

import com.google.gson.annotations.SerializedName;

public class SpriteResponse {
    @SerializedName("front_default")
    private String frontDefault;

    @SerializedName("back_default")
    private String backDefault;

    public SpriteResponse(String frontDefault, String backDefault) {
        this.frontDefault = frontDefault;
        this.backDefault = backDefault;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }
}
