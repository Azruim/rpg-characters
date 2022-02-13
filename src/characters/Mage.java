package characters;

import attributes.PrimaryAttribute;
import enums.ArmorType;
import enums.WeaponType;

public class Mage extends Character{

    public Mage(String name) {
        this.name = name;
        this.base = new PrimaryAttribute(1, 1, 8);
        this.onLevelUp = new PrimaryAttribute(1, 1, 5);
        this.weaponWhiteList.add(WeaponType.WAND);
        this.weaponWhiteList.add(WeaponType.STAFF);
        this.armorWhiteList.add(ArmorType.CLOTH);
        updateTotalAttributes();
    }

    public float calculateDamage() {
        return this.calculateBaseDamage() * (1 + total.getIntelligence() / 100f);
    }
}