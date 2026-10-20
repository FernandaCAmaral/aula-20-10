package com.gc.pokemonapi.entity;

import java.util.List;

public record Pokemon(Integer id, String name, List<TypeSlot> types ) {

    public record TypeSlot(int slot, Type type) {}

    public record Type(String name) {}

    @Override
    public String toString() {
        return "com.example.apirestwithspring.entities.Pokemon: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + types +
                '}';
    }
}
