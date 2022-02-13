package items;

import enums.Slot;
import enums.WeaponType;

public class Weapon extends Item {
    private final WeaponType type;
    private final int damage;
    private final float attackSpeed;

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

    public int getDamage() {
        return damage;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }
}
