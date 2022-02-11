package com.assignment1;

public class Armor extends Item{
    private ArmorType type;
    private PrimaryAttribute attribute;

    public Armor(String name, int minLevel, ArmorType type, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.minLevel = minLevel;
        this.type = type;
        this.attribute = new PrimaryAttribute(strength, dexterity, intelligence);
    }

    public ArmorType getType() {
        return type;
    }

    public PrimaryAttribute getAttribute() {
        return attribute;
    }
}
