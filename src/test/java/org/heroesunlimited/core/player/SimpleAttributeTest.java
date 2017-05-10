package org.heroesunlimited.core.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleAttributeTest {

    @Test
    void creationTest() {
        SimpleAttribute actual = new SimpleAttribute(20);

        int expectedCurrent = 20;
        int expectedInitial = 20;

        assertEquals(expectedCurrent, actual.getCurrent(), "Current");
        assertEquals(expectedInitial, actual.getInitial(), "Initial");
    }
    
    @Test
    void takeDamage() {
        SimpleAttribute actual = new SimpleAttribute(20);

        actual.damage(10);

        int expectedCurrent = 10;
        int expectedInitial = 20;

        assertEquals(expectedCurrent, actual.getCurrent(), "Current");
        assertEquals(expectedInitial, actual.getInitial(), "Initial");
    }

    @Test
    void takeSeriousDamage() {
        SimpleAttribute actual = new SimpleAttribute(20);

        actual.damage(30);

        int expectedCurrent = 0;
        int expectedInitial = 20;

        assertEquals(expectedCurrent, actual.getCurrent(), "Current");
        assertEquals(expectedInitial, actual.getInitial(), "Initial");
    }

    @Test
    void heal() {
        SimpleAttribute actual = new SimpleAttribute(20);

        actual.damage(10);
        actual.heal(5);

        int expectedCurrent = 15;
        int expectedInitial = 20;

        assertEquals(expectedCurrent, actual.getCurrent(), "Current");
        assertEquals(expectedInitial, actual.getInitial(), "Initial");
    }


    @Test
    void fullHeal() {
        SimpleAttribute actual = new SimpleAttribute(20);

        actual.damage(10);
        actual.heal(20);

        int expectedCurrent = 20;
        int expectedInitial = 20;

        assertEquals(expectedCurrent, actual.getCurrent(), "Current");
        assertEquals(expectedInitial, actual.getInitial(), "Initial");
    }
}