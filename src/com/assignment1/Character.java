package com.assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Character {
    protected String name;
    protected int level = 1;

    protected PrimaryAttribute onLevelUp;
    protected PrimaryAttribute base;
    protected PrimaryAttribute total = new PrimaryAttribute(0, 0,0);

    protected HashMap<Slot, Item> equipment = new HashMap<>();
    protected ArrayList<WeaponType> weaponWhiteList = new ArrayList<>();
    protected ArrayList<ArmorType> armorWhiteList = new ArrayList<>();

    public void updateTotalAttributes() {
        PrimaryAttribute armor = getArmorAttributes();
        this.total.setStrength(base.getStrength() + onLevelUp.getStrength() * (level - 1) + armor.getStrength());
        this.total.setDexterity(base.getDexterity() + onLevelUp.getDexterity() * (level - 1) + armor.getDexterity());
        this.total.setIntelligence(base.getIntelligence() + onLevelUp.getIntelligence() * (level - 1) + armor.getIntelligence());
    }

    public void setLevel(int level) {
        this.level = Math.max(level, 1);
        updateTotalAttributes();
    }

    public void levelUp() {
        this.level += 1;
        updateTotalAttributes();
    }

    public void equipItem(Item item) {
        if (item.slot == Slot.WEAPON) {
            if (weaponWhiteList.contains(((Weapon) item).getType()) && item.minLevel <= level)
                equipment.put(item.slot, item);
            else {
                // TODO Throw InvalidWeaponException
                System.out.print("Invalid weapon exception!");
            }
        }
        else {
            if (armorWhiteList.contains(((Armor) item).getType()) && item.minLevel <= level) {
                equipment.put(item.slot, item);
            }
            else {
                // TODO Throw InvalidArmorException
            }
        }
        updateTotalAttributes();
    }

    public PrimaryAttribute getArmorAttributes() {
        int strength = 0;
        int dexterity = 0;
        int intelligence = 0;
        for (Map.Entry<Slot, Item> entry : equipment.entrySet()) {
            if (entry.getKey() != Slot.WEAPON) {
                strength += ((Armor) entry.getValue()).getAttribute().getStrength();
                dexterity += ((Armor) entry.getValue()).getAttribute().getDexterity();
                intelligence += ((Armor) entry.getValue()).getAttribute().getIntelligence();
            }
        }
        return new PrimaryAttribute(strength, dexterity, intelligence);
    }
}
