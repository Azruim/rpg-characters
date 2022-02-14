package characters;

import attributes.PrimaryAttributes;
import enums.ArmorType;
import enums.WeaponType;

public class Mage extends Character{

    public Mage(String name) {
        this.name = name;
        this.base = new PrimaryAttributes(1, 1, 8);
        this.onLevelUp = new PrimaryAttributes(1, 1, 5);
        this.weaponWhiteList.add(WeaponType.WAND);
        this.weaponWhiteList.add(WeaponType.STAFF);
        this.armorWhiteList.add(ArmorType.CLOTH);
        updateTotalAttributes();
    }

    public float calculateDamage() {
        return this.calculateBaseDamage() * (1 + total.getIntelligence() / 100f);
    }
}