package com.assignment1;

public class Weapon extends Item {
    private WeaponType type;
    private int damage;
    private float attackSpeed;

    public Weapon(String name, int minLevel, WeaponType type, int damage, float attackSpeed) {
        this.name = name;
        this.minLevel = minLevel;
        this.type = type;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.slot = Slot.WEAPON;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}
