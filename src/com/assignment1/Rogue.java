package com.assignment1;

public class Rogue extends Character {
    public Rogue(String name) {
        this.name = name;
        this.base = new PrimaryAttribute(2, 6, 1);
        this.onLevelUp = new PrimaryAttribute(1, 4, 1);
        this.weaponWhiteList.add(WeaponType.DAGGER);
        this.weaponWhiteList.add(WeaponType.SWORD);
        this.armorWhiteList.add(ArmorType.LEATHER);
        this.armorWhiteList.add(ArmorType.MAIL);
        updateTotalAttributes();
    }

    public float calculateDamage() {
        return this.calculateBaseDamage() * (1 + total.getDexterity() / 100f);
    }
}
