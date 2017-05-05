package org.heroesunlimited.core.player;

public enum StructuralAttribute {
    STRENGTH("Strength", "STR"),
    DEXTERITY("Dexterity", "DEX"),
    INTELLIGENCE("Intelligence", "INT"),
    DEFENSE("Defense", "DEF");

    private String name;
    private String symbol;

    StructuralAttribute(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}
