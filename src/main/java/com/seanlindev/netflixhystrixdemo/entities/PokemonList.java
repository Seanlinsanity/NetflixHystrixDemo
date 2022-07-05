package com.seanlindev.netflixhystrixdemo.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonList {
    private List<Pokemon> results;
}
