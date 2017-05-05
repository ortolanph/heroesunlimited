package org.heroesunlimited.core.player;

public class LevelInfo {
    public static final LevelInfo LEVEL_ONE = new LevelInfo();

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

        if ((next - experience) < 0) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        int remaining = (next - experience) * -1;
        next = (int)(next * 1.6) - remaining;
    }

    private Integer level = 1;
    private Integer experience = 0;
    private Integer next = 1200;
}
