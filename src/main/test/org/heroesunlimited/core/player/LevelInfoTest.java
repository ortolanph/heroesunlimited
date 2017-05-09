package org.heroesunlimited.core.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LevelInfoTest {

    @Test
    public void mustBeLevelOne() {
        LevelInfo actual = LevelInfo.levelOne();

        LevelInfo expected = buildLevelOne();

        Assertions.assertEquals(expected.getExperience(), actual.getExperience(), "Experience");
        Assertions.assertEquals(expected.getNext(), actual.getNext(), "Next");
        Assertions.assertEquals(expected.getLevel(), actual.getLevel(), "Level");
    }

    @Test
    public void mustBeLevelTwo() {
        LevelInfo actual = LevelInfo.levelOne();
        actual.addExperience(NECESSARY_EXPERIENCE_AMOUNT);

        LevelInfo expected = buildLevelInfo(2, 1200, 3120);

        Assertions.assertEquals(expected.getExperience(), actual.getExperience(), "Experience");
        Assertions.assertEquals(expected.getNext(), actual.getNext(), "Next");
        Assertions.assertEquals(expected.getLevel(), actual.getLevel(), "Level");
    }

    @Test
    public void mustBeLevelTwoWithRemainingExperience() {
        LevelInfo actual = LevelInfo.levelOne();
        actual.addExperience(NEW_EXPERIENCE_AMOUNT);

        LevelInfo expected = buildLevelInfo(2, 1500, 3120);

        Assertions.assertEquals(expected.getExperience(), actual.getExperience(), "Experience");
        Assertions.assertEquals(expected.getNext(), actual.getNext(), "Next");
        Assertions.assertEquals(expected.getLevel(), actual.getLevel(), "Level");
    }

    @Test
    public void mustMultipleLevelUp() {
        LevelInfo actual = LevelInfo.levelOne();
        actual.addExperience(HUGE_EXPERIENCE_AMOUNT);

        LevelInfo expected = buildLevelInfo(3, 5000, 6192);

        Assertions.assertEquals(expected.getExperience(), actual.getExperience(), "Experience");
        Assertions.assertEquals(expected.getNext(), actual.getNext(), "Next");
        Assertions.assertEquals(expected.getLevel(), actual.getLevel(), "Level");
    }

    private static final Integer NECESSARY_EXPERIENCE_AMOUNT = 1200;
    private static final Integer NEW_EXPERIENCE_AMOUNT = 1500;
    private static final Integer HUGE_EXPERIENCE_AMOUNT = 5000;


    public LevelInfo buildLevelOne() {
        LevelInfo levelOne = new LevelInfo();

        levelOne.setExperience(0);
        levelOne.setNext(1200);
        levelOne.setLevel(1);

        return levelOne;
    }

    public LevelInfo buildLevelInfo(int level, int experience, int next) {
        LevelInfo newLevel = new LevelInfo();

        newLevel.setLevel(level);
        newLevel.setExperience(experience);
        newLevel.setNext(next);

        return newLevel;
    }
}