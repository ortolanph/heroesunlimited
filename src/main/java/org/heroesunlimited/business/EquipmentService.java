package org.heroesunlimited.business;

import org.heroesunlimited.core.database.EquipmentDatabase;
import org.heroesunlimited.core.database.HeroesDatabase;
import org.heroesunlimited.core.player.Equipment;
import org.heroesunlimited.core.player.EquipmentType;
import org.heroesunlimited.core.player.PlayableCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EquipmentService {

    public PlayableCharacter equipWeapon(String id, int weaponId) {
        return equip(id, EquipmentType.WEAPON, weaponId);
    }

    public PlayableCharacter equipShield(String id, int shieldId) {
        return equip(id, EquipmentType.SHIELD, shieldId);
    }

    public PlayableCharacter equipArmor(String id, int armorId) {
        return equip(id, EquipmentType.ARMOR, armorId);
    }

    public PlayableCharacter equipBoots(String id, int bootsId) {
        return equip(id, EquipmentType.BOOTS, bootsId);
    }

    public PlayableCharacter equipHelmet(String id, int helmetId) {
        return equip(id, EquipmentType.HELMET, helmetId);
    }

    public PlayableCharacter equipAccessory(String id, int accessoryId) {
        return equip(id, EquipmentType.ACCESSORY, accessoryId);
    }

    public List<Equipment> ofKind(String kind) {
        return equipmentDatabase.findByKind(EquipmentType.valueOf(kind));
    }

    public List<EquipmentType> getKinds() {
        return Arrays.asList(EquipmentType.values());
    }


    @Autowired
    private HeroesDatabase heroesDatabase;

    @Autowired
    private EquipmentDatabase equipmentDatabase;

    private PlayableCharacter equip(String id, EquipmentType type, int equipmentId) {
        PlayableCharacter character = heroesDatabase.findById(id);

        character.equip(type, equipmentDatabase.find(type, equipmentId));

        return character;
    }
}
