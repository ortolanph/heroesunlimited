package org.heroesunlimited.core.builder;

import org.heroesunlimited.core.player.*;
import org.heroesunlimited.core.util.SerialNumber;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayableCharacterBuilder {

    public static PlayableCharacterBuilder getInstance() {
        return INSTANCE;
    }

    public PlayableCharacterBuilder newPlayer(String name) {
        player = new PlayableCharacter();
        player.setId(SerialNumber.generate());
        player.setName(name);
        player.setLevelInfo(LevelInfo.levelOne());
        return this;
    }

    public PlayableCharacterBuilder withClass(PlayerClass playerClass) {
        player.setPlayerClass(playerClass);
        return this;
    }

    public PlayableCharacterBuilder withRace(PlayerRace playerRace) {
        player.setPlayerRace(playerRace);
        return this;
    }

    public PlayableCharacter defaultPlayer(String name) {
        return newPlayer(name)
                .withClass(DEFAULT_PLAYER_CLASS)
                .withRace(DEFAULT_PLAYER_RACE)
                .build();
    }

    public PlayableCharacter playerWithClass(String name, String className) {
        return newPlayer(name)
                .withClass(PlayerClass.find(className))
                .withRace(DEFAULT_PLAYER_RACE)
                .build();
    }

    public PlayableCharacter playerWithClassAndRace(String name, String className, String raceName, Gender gender) {
        return newPlayer(name)
                .withClass(PlayerClass.find(className))
                .withRace(PlayerRace.find(raceName, gender))
                .build();
    }

    public PlayableCharacter build() {
        player.setLife(attributeBuilder.calculateLifePoints(player.getPlayerRace(), player.getPlayerClass()));
        player.setMana(attributeBuilder.calculateManaPoints(player.getPlayerRace(), player.getPlayerClass()));

        Arrays
                .stream(StructuralAttribute.values())
                .forEach(v -> player.setStructuralAttribute(
                        v,
                        attributeBuilder.calculateStructuralAttributeFor(
                                v,
                                player.getPlayerRace(),
                                player.getPlayerClass(),
                                new ArrayList<>())));

        return this.player;
    }

    private PlayableCharacterBuilder() {
    }

    private PlayableCharacter player;
    private static final PlayableCharacterBuilder INSTANCE = new PlayableCharacterBuilder();
    private AttributeBuilder attributeBuilder = new AttributeBuilder();
    private static final PlayerClass DEFAULT_PLAYER_CLASS = PlayerClass.WARRIOR;
    private static final PlayerRace DEFAULT_PLAYER_RACE = PlayerRace.HUMAN_MALE;
}
