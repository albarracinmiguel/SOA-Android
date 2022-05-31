package com.example.androidsoa.network.PokemonService;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonResponse {
    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("types")
    private List<PokemonTypeResponse> types;

    @SerializedName("sprites")
    private SpriteResponse sprites;

    public PokemonResponse() {
    }

    public PokemonResponse(long id, String name, List<PokemonTypeResponse> types) {
        this.id = id;
        this.name = name;
        this.types = types;
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

    public List<PokemonTypeResponse> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonTypeResponse> types) {
        this.types = types;
    }

    public SpriteResponse getSprites() {
        return sprites;
    }

    public void setSprites(SpriteResponse sprites) {
        this.sprites = sprites;
    }
}
