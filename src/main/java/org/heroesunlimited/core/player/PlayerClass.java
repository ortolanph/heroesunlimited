package org.heroesunlimited.core.player;

import java.util.Arrays;

public enum PlayerClass {

    CLERIC("Cleric", new AttributeModifier(5, 15, 5, 5, 15, 5)),
    ROGUE("Rogue", new AttributeModifier(10, 5, 10, 15, 10, 10)),
    WARRIOR("Warrior", new AttributeModifier(15 , 5, 15, 5, 5, 15));

    private String name;
    private AttributeModifier modifier;

    PlayerClass(String name, AttributeModifier modifier) {
        this.name = name;
        this.modifier = modifier;
    }

    public static PlayerClass find(String name) {
        return Arrays
                .asList(values())
                .stream()
                .filter(r -> r.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("class %s invalid", name)));
    }

    public AttributeModifier getModifier() {
        return modifier;
    }
}
