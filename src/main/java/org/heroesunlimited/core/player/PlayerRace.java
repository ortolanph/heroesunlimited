package org.heroesunlimited.core.player;

import java.util.Arrays;

public enum PlayerRace {
    HUMAN_MALE("Human", Gender.MALE, new AttributeModifier(7, 5, 7, 5, 5, 7)),
    HUMAN_FEMALE("Human", Gender.FEMALE, new AttributeModifier(5, 3, 5, 7, 5, 5)),
    ELF_MALE("Elf", Gender.MALE, new AttributeModifier(7, 5, 5, 7, 5, 5)),
    ELF_FEMALE("Elf", Gender.FEMALE, new AttributeModifier(5, 5, 5, 7, 5, 5)),
    DWARF_MALE("Dwarf", Gender.MALE, new AttributeModifier(7, 3, 7, 3, 3, 7)),
    DWARF_FEMALE("Dwarf", Gender.FEMALE, new AttributeModifier(7, 3, 7, 3, 3, 7));

    private String name;
    private Gender gender;
    private AttributeModifier modifier;

    PlayerRace(String name, Gender gender, AttributeModifier modifier) {
        this.name = name;
        this.gender = gender;
        this.modifier = modifier;
    }

    public PlayerRace find(String race, Gender gender) {
        return Arrays
                .asList(values())
                .stream()
                .filter(r -> r.name.equals(race))
                .filter(r -> r.gender.equals(gender))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("race %s or gender %s invalid", race, gender)));
    }

    public AttributeModifier getModifier() {
        return modifier;
    }
}
