package org.heroesunlimited.business;

import org.heroesunlimited.core.builder.PlayableCharacterBuilder;
import org.heroesunlimited.core.database.HeroesDatabase;
import org.heroesunlimited.core.player.Gender;
import org.heroesunlimited.core.player.PlayableCharacter;
import org.heroesunlimited.core.player.PlayerClass;
import org.heroesunlimited.core.player.PlayerRace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PlayerService {

    @Autowired
    private HeroesDatabase heroesDatabase;

    public PlayableCharacter build(String name) {
        PlayableCharacter character = PlayableCharacterBuilder.getInstance().defaultPlayer(name);

        heroesDatabase.insert(character);

        return character;
    }

    public PlayableCharacter build(String name, String playerClass) {
        PlayableCharacter character = PlayableCharacterBuilder.getInstance().playerWithClass(name, playerClass);

        heroesDatabase.insert(character);

        return character;
    }

    public PlayableCharacter build(String name, String playerClass, String playerRace, String gender) {
        PlayableCharacter character = PlayableCharacterBuilder.getInstance().playerWithClassAndRace(name, playerClass, playerRace, Gender.valueOf(gender));

        heroesDatabase.insert(character);

        return character;
    }

    public PlayableCharacter getById(String id) {
        return heroesDatabase.findById(id);
    }

    public PlayableCharacter getByName(String name) {
        return heroesDatabase.findByName(name);
    }

    public List<PlayerRace> getRaces() {
        return Arrays.asList(PlayerRace.values());
    }

    public List<PlayerClass> getClasses() {
        return Arrays.asList(PlayerClass.values());
    }

}
