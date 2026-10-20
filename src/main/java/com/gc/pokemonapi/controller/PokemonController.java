package com.gc.pokemonapi.controller;

import com.gc.pokemonapi.entity.Pokemon;
import com.gc.pokemonapi.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokeApi")
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/pokemon/{pokemon_name}")
    public Pokemon whoIsThatPokemon (@PathVariable String pokemon_name){
        return service.getPokemonByName(pokemon_name);
    }

    @GetMapping("/pokemon")
    public List<Pokemon> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping("/pokemon/add/{pokemon_name}")
    @ResponseStatus(HttpStatus.CREATED)
    public Pokemon adicionar(@PathVariable String pokemon_name) {
        return service.adicionar(pokemon_name);
    }

    @DeleteMapping("/pokemon/{pokemon_name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String pokemon_name) {
        service.deletar(pokemon_name);
    }


}
