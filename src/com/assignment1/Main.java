package com.assignment1;

public class Main {

    public static void main(String[] args) {
        Mage gandalf = new Mage("Gandalf");

        Weapon staff = new Weapon(
                "Staff of Destiny",
                3,
                WeaponType.STAFF,
                5,
                2);

        Armor robe = new Armor(
                "Gray Robes",
                2,
                ArmorType.CLOTH,
                Slot.BODY,
                1,
                1,
                5);

        gandalf.levelUp();
        gandalf.equipItem(staff);
        System.out.print(gandalf.calculateDamage() + "\n");
        gandalf.equipItem(robe);
        System.out.print(gandalf.calculateDamage() + "\n");
        System.out.print(gandalf.characterSheet());
    }
}
