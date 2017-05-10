package org.heroesunlimited.core.builder;

import org.heroesunlimited.core.dice.D20Roller;
import org.heroesunlimited.core.player.*;

import java.util.List;

public class AttributeBuilder {

    public SimpleAttribute calculateLifePoints(PlayerRace playerRace, PlayerClass playerClass) {
        return new SimpleAttribute(D20Roller.rollMultiple(2)
                + playerRace.getModifier().getLife()
                + playerClass.getModifier().getLife());
    }

    public SimpleAttribute calculateManaPoints(PlayerRace playerRace, PlayerClass playerClass) {
        return new SimpleAttribute(D20Roller.rollMultiple(2)
                + playerRace.getModifier().getMana()
                + playerClass.getModifier().getMana());
    }

    public Integer calculateStructuralAttributeFor(StructuralAttribute attribute, PlayerRace playerRace, PlayerClass playerClass, List<Equipment> equipment) {
        return playerRace.getModifier().getAttributeById(attribute) +
                playerClass.getModifier().getAttributeById(attribute) +
                equipment.stream().mapToInt(e -> e.getModifier().getAttributeById(attribute)).sum();
    }

}
