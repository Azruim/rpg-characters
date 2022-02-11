package com.assignment1;

public class Mage extends Character{

    Mage(String name) {
        this.name = name;
        this.base = new PrimaryAttribute(1, 1, 8);
        this.onLevelUp = new PrimaryAttribute(1, 1, 5);
        this.weaponWhiteList.add(WeaponType.WAND);
        this.weaponWhiteList.add(WeaponType.STAFF);
        this.armorWhiteList.add(ArmorType.CLOTH);
        updateTotalAttributes();
    }

    public float calculateDamage() {
        int damage;
        float attackSpeed;
        Weapon weapon = ((Weapon)equipment.get(Slot.WEAPON));
        if (weapon == null) {
            damage = 0;
            attackSpeed = 0;
        }
        else {
            damage = ((Weapon)equipment.get(Slot.WEAPON)).getDamage();
            attackSpeed = ((Weapon)equipment.get(Slot.WEAPON)).getAttackSpeed();
        }
        return damage * attackSpeed * (1 + total.getIntelligence() / 100f);
    }
}