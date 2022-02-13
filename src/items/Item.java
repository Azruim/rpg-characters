package items;

import enums.Slot;

public abstract class Item {
    protected String name;
    protected int minLevel;
    protected Slot slot;

    public String getName() {
        return name;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public Slot getSlot() {
        return slot;
    }
}
