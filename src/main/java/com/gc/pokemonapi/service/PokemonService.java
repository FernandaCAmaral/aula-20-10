package com.gc.pokemonapi.service;

import com.gc.pokemonapi.entity.Pokemon;
import com.gc.pokemonapi.repository.PokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;

@Service
public class PokemonService {

    private final RestClient client;
    private final PokemonRepository repository;

    public PokemonService(RestClient.Builder builder, PokemonRepository repository) {
        this.client = RestClient.builder().baseUrl("https://pokeapi.co/api/v2").build();
        this.repository = repository;
    }

    public List<Pokemon> listarTodos() {
        return repository.listarTodos();
    }

    public Pokemon adicionar(String nome) {
        Pokemon pokemon = getPokemonByName(nome);
        return repository.adicionar(pokemon);
    }

    public void deletar(String nome) {
        boolean removido = repository.deletar(nome);
    }

    public Pokemon getPokemonByName (String pokemon_name){
       return  Objects.requireNonNull(client.get()
                       .uri("/pokemon/{pokemon_name}", pokemon_name.toLowerCase())
                       .retrieve()
                       .body(Pokemon.class));
    }

}
