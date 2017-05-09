package org.heroesunlimited.core.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerClassTest {

    @Test
    public void findCleric() throws Exception {
        PlayerClass actual = PlayerClass.CLERIC;

        PlayerClass expected = PlayerClass.find(CLERIC_CLASS);

        assertEquals(expected, actual, "PlayerClass");
    }

    @Test
    public void findRogue() throws Exception {
        PlayerClass actual = PlayerClass.ROGUE;

        PlayerClass expected = PlayerClass.find(ROGUE_CLASS);

        assertEquals(expected, actual, "PlayerClass");
    }

    @Test
    public void findWarrior() throws Exception {
        PlayerClass actual = PlayerClass.WARRIOR;

        PlayerClass expected = PlayerClass.find(WARRIOR_CLASS);

        assertEquals(expected, actual, "PlayerClass");
    }

    @Test
    public void findException() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> PlayerClass.find(OTHER_CLASS));
    }

    private static final String CLERIC_CLASS = "Cleric";
    private static final String ROGUE_CLASS = "Rogue";
    private static final String WARRIOR_CLASS = "Warrior";
    private static final String OTHER_CLASS = "Other";
}