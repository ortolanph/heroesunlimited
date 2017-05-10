package org.heroesunlimited.core.player;

public class AttributeModifier {

    public AttributeModifier() {}

    public AttributeModifier(Integer life, Integer mana, Integer strength, Integer dexterity, Integer intelligence, Integer defense) {
        this.life = life;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.defense = defense;
    }

    public AttributeModifier(Integer strength, Integer dexterity, Integer intelligence, Integer defense) {
        this.life = life;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.defense = defense;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getAttributeById(StructuralAttribute id) {
        Integer value = 0;

        switch (id) {
            case STRENGTH:
                value = getStrength();
                break;
            case DEFENSE:
                value = getDefense();
                break;
            case DEXTERITY:
                value = getDexterity();
                break;
            case INTELLIGENCE:
                value = getIntelligence();
        }

        return value;
    }

    private Integer life = 0;
    private Integer mana = 0;
    private Integer strength = 0;
    private Integer dexterity = 0;
    private Integer intelligence = 0;
    private Integer defense = 0;
}
