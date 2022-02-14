package characters;

import attributes.PrimaryAttributes;
import enums.ArmorType;
import enums.WeaponType;

public class Rogue extends Character {
    public Rogue(String name) {
        this.name = name;
        this.base = new PrimaryAttributes(2, 6, 1);
        this.onLevelUp = new PrimaryAttributes(1, 4, 1);
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
