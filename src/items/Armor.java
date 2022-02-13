package items;

import enums.ArmorType;
import attributes.PrimaryAttribute;
import enums.Slot;

public class Armor extends Item{
    private final ArmorType type;
    private final PrimaryAttribute attribute;

    public Armor(String name, int minLevel, ArmorType type, Slot slot , int strength, int dexterity, int intelligence) {
        this.name = name;
        this.minLevel = minLevel;
        this.type = type;
        this.attribute = new PrimaryAttribute(strength, dexterity, intelligence);
        this.slot = slot;
    }

    public ArmorType getType() {
        return type;
    }

    public PrimaryAttribute getAttribute() {
        return attribute;
    }
}
