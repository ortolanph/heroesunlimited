package org.heroesunlimited.core.database;

import org.heroesunlimited.core.player.AttributeModifier;
import org.heroesunlimited.core.player.Equipment;
import org.heroesunlimited.core.player.EquipmentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.heroesunlimited.core.player.EquipmentType.WEAPON;
import static org.junit.jupiter.api.Assertions.*;

class EquipmentDatabaseTest {

    private EquipmentDatabase equipment;

    @BeforeEach
    public void setUp() {
        equipment = new EquipmentDatabase();
    }

    @Test
    public void found() throws Exception {
        Equipment expected = new Equipment(1, WEAPON, "Wood Sword", new AttributeModifier(3, 0, 0, 0));

        Equipment actual = equipment.find(EquipmentType.WEAPON, 1);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getType(), actual.getType());
    }

    @Test
    public void notFound() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> equipment.find(EquipmentType.WEAPON, 6));
    }

}