package com.assignment1;

public class Ranger extends Character {
    public Ranger(String name) {
        this.name = name;
        this.base = new PrimaryAttribute(1, 7, 1);
        this.onLevelUp = new PrimaryAttribute(1, 5, 1);
        this.weaponWhiteList.add(WeaponType.BOW);
        this.armorWhiteList.add(ArmorType.LEATHER);
        this.armorWhiteList.add(ArmorType.MAIL);
        updateTotalAttributes();
    }

    public float calculateDamage() {
        return this.calculateBaseDamage() * (1 + total.getDexterity() / 100f);
    }
}
