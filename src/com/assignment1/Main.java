package com.assignment1;

public class Main {

    public static void main(String[] args) {
        Mage gandalf = new Mage("Gandalf");

        Weapon staff = new Weapon(
                "Staff of Destiny",
                2,
                WeaponType.STAFF,
                5,
                2);

        System.out.print(gandalf.calculateDamage() + "\n");
        gandalf.equipItem(staff);
        gandalf.levelUp();
        System.out.print(gandalf.calculateDamage() + "\n");
        gandalf.equipItem(staff);
        System.out.print(gandalf.calculateDamage() + "\n");
    }
}
