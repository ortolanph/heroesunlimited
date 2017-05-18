package org.heroesunlimited.core.database;

import org.heroesunlimited.core.player.AttributeModifier;
import org.heroesunlimited.core.player.Equipment;
import org.heroesunlimited.core.player.EquipmentType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.heroesunlimited.core.player.EquipmentType.*;

@Component
public class EquipmentDatabase {

    public EquipmentDatabase() {
        load();
    }

    public Equipment find(EquipmentType type, Integer id) {
        return equipment
                .stream()
                .filter(e -> e.getType().equals(type))
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("type %s or id %s invalid", type, id)));
    }

    public List<Equipment> findByKind(EquipmentType type) {
        return equipment
                .stream()
                .filter(e -> e.getType().equals(type))
                .collect(Collectors.toList());
    }

    private void load() {
        //Weapons
        equipment.add(new Equipment(1, WEAPON, "Wood Sword", new AttributeModifier(3, 0, 0, 0)));
        equipment.add(new Equipment(2, WEAPON, "Iron Sword", new AttributeModifier(5, 0, 0, 0)));
        equipment.add(new Equipment(3, WEAPON, "Green Destiny", new AttributeModifier(7, 0, 3, 0)));
        equipment.add(new Equipment(4, WEAPON, "Hruting", new AttributeModifier(9, 3, 0, 0)));
        equipment.add(new Equipment(5, WEAPON, "Excalibur", new AttributeModifier(11, 0, 5, 0)));
        //Shields
        equipment.add(new Equipment(1, SHIELD, "Wood Shield", new AttributeModifier(0, 0, 0, 3)));
        equipment.add(new Equipment(2, SHIELD, "Iron Shield", new AttributeModifier(0, 0, 0, 5)));
        equipment.add(new Equipment(3, SHIELD, "Steel Shield", new AttributeModifier(0, 0, 0, 7)));
        equipment.add(new Equipment(4, SHIELD, "Oakenshield", new AttributeModifier(0, 3, 0, 9)));
        equipment.add(new Equipment(5, SHIELD, "Mithril Shield", new AttributeModifier(3, 5, 0, 11)));
        //Armors
        equipment.add(new Equipment(1, ARMOR, "Wood Armor", new AttributeModifier(0, 0, 0, 3)));
        equipment.add(new Equipment(2, ARMOR, "Iron Armor", new AttributeModifier(0, 0, 0, 5)));
        equipment.add(new Equipment(3, ARMOR, "Steel Armor", new AttributeModifier(0, 0, 0, 7)));
        equipment.add(new Equipment(4, ARMOR, "Mithril Vest", new AttributeModifier(0, 3, 0, 9)));
        equipment.add(new Equipment(5, ARMOR, "Golden Armor", new AttributeModifier(3, 5, 0, 11)));
        //Boots
        equipment.add(new Equipment(1, BOOTS, "Furry Boots", new AttributeModifier(0, 3, 0, 0)));
        equipment.add(new Equipment(2, BOOTS, "Leather Boots", new AttributeModifier(0, 5, 0, 0)));
        equipment.add(new Equipment(3, BOOTS, "Steel Boots", new AttributeModifier(0, 7, 3, 0)));
        equipment.add(new Equipment(4, BOOTS, "Mithril Boots", new AttributeModifier(0, 9, 5, 3)));
        equipment.add(new Equipment(5, BOOTS, "Dragon Boots", new AttributeModifier(0, 11, 7, 0)));
        //Helmet
        equipment.add(new Equipment(1, HELMET, "Viking Helmet", new AttributeModifier(3, 0, 0, 3)));
        equipment.add(new Equipment(2, HELMET, "Green Beret", new AttributeModifier(0, 3, 0, 5)));
        equipment.add(new Equipment(3, HELMET, "Crusader Helmet", new AttributeModifier(0, 0, 3, 7)));
        equipment.add(new Equipment(4, HELMET, "Mithril Helmet", new AttributeModifier(0, 5, 0, 9)));
        equipment.add(new Equipment(5, HELMET, "Dragon Head", new AttributeModifier(5, 0, 0, 11)));
        //Accessory
        equipment.add(new Equipment(1, ACCESSORY, "STR Pendant", new AttributeModifier(3, 0, 0, 0)));
        equipment.add(new Equipment(2, ACCESSORY, "DEX Bracelet", new AttributeModifier(0, 3, 0, 0)));
        equipment.add(new Equipment(3, ACCESSORY, "INT Ribbon", new AttributeModifier(0, 0, 3, 0)));
        equipment.add(new Equipment(4, ACCESSORY, "DEF Shoulder Pads", new AttributeModifier(0, 0, 0, 3)));
        equipment.add(new Equipment(5, ACCESSORY, "Ring of Destiny", new AttributeModifier(5, 5, 5, 5)));
        equipment.add(new Equipment(6, ACCESSORY, "Smart Ring", new AttributeModifier(-3, -3, 7, -3)));
        equipment.add(new Equipment(7, ACCESSORY, "Invisibility Ring", new AttributeModifier(-3, 7, -3, -3)));
        equipment.add(new Equipment(8, ACCESSORY, "Ring of Fire", new AttributeModifier(7, -3, -3, -3)));
        equipment.add(new Equipment(9, ACCESSORY, "Energy Ring", new AttributeModifier(-3, -3, -3, 7)));

    }

    private List<Equipment> equipment = new ArrayList<>();
}
