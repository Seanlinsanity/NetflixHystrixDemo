package com.seanlindev.netflixhystrixdemo.controller;

import com.seanlindev.netflixhystrixdemo.entities.Pokemon;
import com.seanlindev.netflixhystrixdemo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/pokemon")
    public Pokemon getPokemon() {
        System.out.println("[" + LocalTime.now() + "] receive a new request");
        return pokemonService.getPokemon();
    }
}
