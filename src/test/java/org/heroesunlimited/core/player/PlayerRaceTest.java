package org.heroesunlimited.core.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerRaceTest {

    @Test
    void findHumanMale() throws Exception {
        PlayerRace actual = PlayerRace.HUMAN_MALE;

        PlayerRace expected = PlayerRace.find(HUMAN_RACE, Gender.MALE);

        assertEquals(expected, actual, "PlayerRace");
    }

    @Test
    void findHumanFemale() throws Exception {
        PlayerRace actual = PlayerRace.HUMAN_FEMALE;

        PlayerRace expected = PlayerRace.find(HUMAN_RACE, Gender.FEMALE);

        assertEquals(expected, actual, "PlayerRace");
    }

    @Test
    void findElfMale() throws Exception {
        PlayerRace actual = PlayerRace.ELF_MALE;

        PlayerRace expected = PlayerRace.find(ELF_RACE, Gender.MALE);

        assertEquals(expected, actual, "PlayerRace");
    }

    @Test
    void findElfFemale() throws Exception {
        PlayerRace actual = PlayerRace.ELF_FEMALE;

        PlayerRace expected = PlayerRace.find(ELF_RACE, Gender.FEMALE);

        assertEquals(expected, actual, "PlayerRace");
    }

    @Test
    void findDwarfMale() throws Exception {
        PlayerRace actual = PlayerRace.DWARF_MALE;

        PlayerRace expected = PlayerRace.find(DWARF_RACE, Gender.MALE);

        assertEquals(expected, actual, "PlayerRace");
    }

    @Test
    void findDwarfFemale() throws Exception {
        PlayerRace actual = PlayerRace.DWARF_FEMALE;

        PlayerRace expected = PlayerRace.find(DWARF_RACE, Gender.FEMALE);

        assertEquals(expected, actual, "PlayerRace");
    }

    @Test
    public void findException() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> PlayerRace.find(OTHER_RACE, Gender.MALE));
    }

    private static final String HUMAN_RACE = "Human";
    private static final String ELF_RACE = "Elf";
    private static final String DWARF_RACE = "Dwarf";
    private static final String OTHER_RACE = "Other";
}