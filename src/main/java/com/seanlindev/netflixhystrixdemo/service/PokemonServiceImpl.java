package com.seanlindev.netflixhystrixdemo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.seanlindev.netflixhystrixdemo.entities.Pokemon;
import com.seanlindev.netflixhystrixdemo.entities.PokemonList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;

@Service
public class PokemonServiceImpl implements PokemonService {
    private RestTemplate restTemplate;

    public PokemonServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    @HystrixCommand(fallbackMethod = "defaultPokemon")
    public Pokemon getPokemon() {
        System.out.println("[" + LocalTime.now() + "] call remote service...");
        PokemonList pokemonList = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon", PokemonList.class);
        System.out.println("[" + LocalTime.now() + "] get remote result successfully");
        return pokemonList.getResults().stream().findFirst().get();
    }

    private Pokemon defaultPokemon() {
        System.out.println("[" + LocalTime.now() + "] fallback default result");
        Pokemon pokemon = new Pokemon();
        pokemon.setName("unknown");
        return pokemon;
    }
}
