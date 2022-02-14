package items;

import enums.ArmorType;
import attributes.PrimaryAttributes;
import enums.Slot;

public class Armor extends Item{
    private final ArmorType type;
    private final PrimaryAttributes attribute;

    public Armor(String name, int minLevel, ArmorType type, Slot slot , int strength, int dexterity, int intelligence) {
        this.name = name;
        this.minLevel = minLevel;
        this.type = type;
        this.attribute = new PrimaryAttributes(strength, dexterity, intelligence);
        this.slot = slot;
    }

    public ArmorType getType() {
        return type;
    }

    public PrimaryAttributes getAttribute() {
        return attribute;
    }
}
