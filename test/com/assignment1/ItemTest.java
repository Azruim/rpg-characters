package com.assignment1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    public void equipItem_minLevelTooHigh_InvalidWeaponException() {
        Warrior warrior = new Warrior("Brienne of Tarth");
        Weapon weapon = new Weapon(
                "Common Axe",
                2,
                WeaponType.AXE,
                7,
                1.1f);

        Assertions.assertThrows(InvalidWeaponException.class, () -> warrior.equipItem(weapon));
    }

    @Test
    public void equipItem_minLevelTooHigh_InvalidArmorException() {
        Warrior warrior = new Warrior("Brienne of Tarth");
        Armor armor = new Armor(
                "Common Plate Body Armor",
                2,
                ArmorType.PLATE,
                Slot.BODY,
                1,
                0,
                0);

        Assertions.assertThrows(InvalidArmorException.class, () -> warrior.equipItem(armor));
    }

    @Test
    public void equipItem_invalidWeaponType_InvalidWeaponException() {
        Warrior warrior = new Warrior("Brienne of Tarth");
        Weapon weapon = new Weapon(
                "Common Bow",
                1,
                WeaponType.BOW,
                12,
                0.8f);

        Assertions.assertThrows(InvalidWeaponException.class, () -> warrior.equipItem(weapon));
    }

    @Test
    public void equipItem_invalidArmorType_InvalidArmorException() {
        Warrior warrior = new Warrior("Brienne of Tarth");
        Armor armor = new Armor(
                "Common Cloth Head Armor",
                1,
                ArmorType.CLOTH,
                Slot.HEAD,
                0,
                0,
                5);

        Assertions.assertThrows(InvalidArmorException.class, () -> warrior.equipItem(armor));
    }

    @Test
    public void equipItem_validWeapon_true() {
        Warrior warrior = new Warrior("Brienne of Tarth");
        Weapon weapon = new Weapon(
                "Common Axe",
                1,
                WeaponType.AXE,
                7,
                1.1f);

        Assertions.assertTrue(warrior.equipItem(weapon));
    }

    @Test
    public void equipItem_validArmor_true() {
        Warrior warrior = new Warrior("Brienne of Tarth");
        Armor armor = new Armor(
                "Common Plate Body Armor",
                1,
                ArmorType.PLATE,
                Slot.BODY,
                1,
                0,
                0);

        Assertions.assertTrue(warrior.equipItem(armor));
    }

    @Test
    public void calculateDamage_noWeapon_correctDps() {
        Warrior warrior = new Warrior("Brienne of Tarth");
        float actual = warrior.calculateDamage();
        float expected = 1f*(1f + (5f / 100f));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateDamage_validWeapon_CorrectDps() {
        Warrior warrior = new Warrior("Brienne of Tarth");
        Weapon weapon = new Weapon(
                "Common Axe",
                1,
                WeaponType.AXE,
                7,
                1.1f);
        warrior.equipItem(weapon);

        float actual = warrior.calculateDamage();
        float expected = (7f * 1.1f)*(1f + (5f / 100f));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateDamage_validWeaponAndValidArmor_correctDps() {
        Warrior warrior = new Warrior("Brienne of Tarth");
        Weapon weapon = new Weapon(
                "Common Axe",
                1,
                WeaponType.AXE,
                7,
                1.1f);
        warrior.equipItem(weapon);

        Armor armor = new Armor(
                "Common Plate Body Armor",
                1,
                ArmorType.PLATE,
                Slot.BODY,
                1,
                0,
                0);
        warrior.equipItem(armor);

        float actual = warrior.calculateDamage();
        float expected = (7f * 1.1f) * (1f + ((5f + 1f) / 100f));

        Assertions.assertEquals(expected, actual);
    }
}