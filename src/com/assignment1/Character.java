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
                System.out.print("Invalid armor exception");
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

    public String characterSheet() {
        StringBuilder string = new StringBuilder("Character name: ");
        string.append(this.name + "\n");
        string.append("Character level: ");
        string.append(this.level + "\n");
        string.append("Strength: ");
        string.append(this.total.getStrength() + "\n");
        string.append("Dexterity: ");
        string.append(this.total.getDexterity() + "\n");
        string.append("Intelligence: ");
        string.append(this.total.getIntelligence() + "\n");
        string.append("DPS: ");
        string.append(this.calculateDamage() + "\n");
        return string.toString();
    }

    public float calculateBaseDamage() {
        int damage;
        float attackSpeed;
        Weapon weapon = ((Weapon) equipment.get(Slot.WEAPON));
        if (weapon == null) {
            damage = 0;
            attackSpeed = 0;
        } else {
            damage = ((Weapon) equipment.get(Slot.WEAPON)).getDamage();
            attackSpeed = ((Weapon) equipment.get(Slot.WEAPON)).getAttackSpeed();
        }
        return damage * attackSpeed;
    }

    public abstract float calculateDamage();
}
