package org.heroesunlimited.core.player;

import java.util.Map;

public class PlayableCharacter {
    public PlayableCharacter() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public LevelInfo getLevelInfo() {
        return levelInfo;
    }

    public void setLevelInfo(LevelInfo levelInfo) {
        this.levelInfo = levelInfo;
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
    }

    public PlayerRace getPlayerRace() {
        return playerRace;
    }

    public void setPlayerRace(PlayerRace playerRace) {
        this.playerRace = playerRace;
    }

    public SimpleAttribute getLife() {
        return life;
    }

    public void setLife(SimpleAttribute life) {
        this.life = life;
    }

    public SimpleAttribute getMana() {
        return mana;
    }

    public void setMana(SimpleAttribute mana) {
        this.mana = mana;
    }

    public Map<StructuralAttribute, Integer> getAttributes() {
        return attributes;
    }

    public void setStructuralAttribute(StructuralAttribute attribute, Integer value) {
        attributes.put(attribute, value);
    }

    public void upgradeStructuralAttribute(StructuralAttribute attribute, Integer value) {
        Integer oldValue = attributes.getOrDefault(attribute, 0);
        Integer newValue = oldValue + value;
        attributes.replace(attribute, newValue);
    }

    public void setAttributes(Map<StructuralAttribute, Integer> attributes) {
        this.attributes = attributes;
    }

    public Map<EquipmentType, Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(Map<EquipmentType, Equipment> equipment) {
        this.equipment = equipment;
    }

    public void equip(EquipmentType type, Equipment equipment) {
        this.equipment.put(type, equipment);
    }

    public void unequip(EquipmentType type) {
        this.equipment.remove(type);
    }

    private String id;
    private String name;
    private Integer gold = 0;
    private LevelInfo levelInfo;
    private PlayerClass playerClass;
    private PlayerRace playerRace;
    private SimpleAttribute life;
    private SimpleAttribute mana;
    private Map<StructuralAttribute, Integer> attributes;
    private Map<EquipmentType, Equipment> equipment;
}