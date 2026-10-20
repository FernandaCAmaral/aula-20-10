package com.gc.pokemonapi.repository;

import com.gc.pokemonapi.entity.Pokemon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PokemonRepository {

    private List<Pokemon> pokemons = new ArrayList<>();

    public List<Pokemon> listarTodos() {
        return pokemons;
    }

    public Pokemon buscarPorNome(String nome) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.name().equalsIgnoreCase(nome)) {
                return pokemon;
            }
        }
        return null;
    }

    public Pokemon adicionar(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon;
    }

    public boolean deletar(String nome) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).name().equalsIgnoreCase(nome)) {
                pokemons.remove(i);
                return true;
            }
        }
        return false;
    }
}
