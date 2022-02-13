package characters;

import attributes.PrimaryAttribute;
import enums.ArmorType;
import enums.WeaponType;

public class Warrior extends Character {
    public Warrior(String name) {
        this.name = name;
        this.base = new PrimaryAttribute(5, 2, 1);
        this.onLevelUp = new PrimaryAttribute(3, 2, 1);
        this.weaponWhiteList.add(WeaponType.AXE);
        this.weaponWhiteList.add(WeaponType.HAMMER);
        this.weaponWhiteList.add(WeaponType.SWORD);
        this.armorWhiteList.add(ArmorType.MAIL);
        this.armorWhiteList.add(ArmorType.PLATE);
        updateTotalAttributes();
    }

    public float calculateDamage() {
        return this.calculateBaseDamage() * (1 + total.getStrength() / 100f);
    }
}
