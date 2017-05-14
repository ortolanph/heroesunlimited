package org.heroesunlimited.core.database;

import org.heroesunlimited.core.player.PlayableCharacter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HeroesDatabase {

    public HeroesDatabase() {

    }

    public PlayableCharacter findById(String id) {
        return heroes
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Player with id %s not found!", id)));
    }

    public PlayableCharacter findByName(String name) {
        return heroes
                .stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Player with name %s not found!", name)));
    }

    public void clearDatabase() {
        heroes.clear();
    }

    private List<PlayableCharacter> heroes = new ArrayList<>();
}
