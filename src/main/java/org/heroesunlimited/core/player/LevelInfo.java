package org.heroesunlimited.core.player;

public class LevelInfo {
    public LevelInfo() {
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public void addExperience(int amount) {
        experience += amount;

        while (next <= experience) {
            levelUp();
        }
    }

    public static LevelInfo levelOne() {
        return new LevelInfo();
    }

    private void levelUp() {
        level++;
        next = (int) (next * 1.6) + BASE_EXPERIENCE_POINTS;
    }

    private Integer level = 1;
    private Integer experience = 0;
    private Integer next = 1200;

    private static final Double FACTOR = 1.6;
    private static final Integer BASE_EXPERIENCE_POINTS = 1200;
}
