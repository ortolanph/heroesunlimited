package org.heroesunlimited.core.player;

public class Equipment {
    public Equipment(int i, EquipmentType weapon) {
    }

    public Equipment(Integer id, EquipmentType type, String name, AttributeModifier modifier) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.modifier = modifier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttributeModifier getModifier() {
        return modifier;
    }

    public void setModifier(AttributeModifier modifier) {
        this.modifier = modifier;
    }

    private Integer id;
    private EquipmentType type;
    private String name;
    private AttributeModifier modifier;
}
