package characters;

import attributes.PrimaryAttributes;
import enums.ArmorType;
import enums.Slot;
import enums.WeaponType;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Armor;
import items.Item;
import items.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Character {
    protected String name;
    protected int level = 1;

    protected PrimaryAttributes onLevelUp;
    protected PrimaryAttributes base;
    protected PrimaryAttributes total = new PrimaryAttributes(0, 0,0);

    protected HashMap<Slot, Item> equipment = new HashMap<>();
    protected ArrayList<WeaponType> weaponWhiteList = new ArrayList<>();
    protected ArrayList<ArmorType> armorWhiteList = new ArrayList<>();

    public PrimaryAttributes getTotal() {
        return total;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = Math.max(level, 1);
        updateTotalAttributes();
    }

    protected void updateTotalAttributes() {
        PrimaryAttributes armor = getArmorAttributes();
        this.total.setStrength(base.getStrength() + onLevelUp.getStrength() * (level - 1) + armor.getStrength());
        this.total.setDexterity(base.getDexterity() + onLevelUp.getDexterity() * (level - 1) + armor.getDexterity());
        this.total.setIntelligence(base.getIntelligence() + onLevelUp.getIntelligence() * (level - 1) + armor.getIntelligence());
    }

    public void levelUp() {
        this.level += 1;
        updateTotalAttributes();
    }

    public boolean equipItem(Item item) {
        if (item.getSlot() == Slot.WEAPON) {
            if (!weaponWhiteList.contains(((Weapon) item).getType()))
                throw new InvalidWeaponException("Cannot equip weapon type " + ((Weapon) item).getType());
            if (item.getMinLevel() > level)
                throw new InvalidWeaponException("Weapon level too high!");
        }
        else {
            if (!armorWhiteList.contains(((Armor) item).getType()))
                throw new InvalidArmorException("Cannot equip armor type " + ((Armor) item).getType());
            if (item.getMinLevel() > level)
                throw new InvalidArmorException("Armor level too high!");
        }
        equipment.put(item.getSlot(), item);
        updateTotalAttributes();
        return true;
    }

    private PrimaryAttributes getArmorAttributes() {
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
        return new PrimaryAttributes(strength, dexterity, intelligence);
    }

    public String characterSheet() {
        String string = "Character name: " + this.name + "\n" +
                "Character level: " +
                this.level + "\n" +
                "Strength: " +
                this.total.getStrength() + "\n" +
                "Dexterity: " +
                this.total.getDexterity() + "\n" +
                "Intelligence: " +
                this.total.getIntelligence() + "\n" +
                "DPS: " +
                this.calculateDamage() + "\n";
        return string;
    }

    protected float calculateBaseDamage() {
        int damage;
        float attackSpeed;
        Weapon weapon = ((Weapon) equipment.get(Slot.WEAPON));
        if (weapon == null) {
            damage = 1;
            attackSpeed = 1;
        } else {
            damage = ((Weapon) equipment.get(Slot.WEAPON)).getDamage();
            attackSpeed = ((Weapon) equipment.get(Slot.WEAPON)).getAttackSpeed();
        }
        return damage * attackSpeed;
    }

    public abstract float calculateDamage();
}