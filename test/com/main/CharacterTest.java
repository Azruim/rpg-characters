package com.main;

import characters.Mage;
import characters.Ranger;
import characters.Rogue;
import characters.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterTest {

    @Test
    public void characterConstructor_characterCreation_isLevel1() {
        Warrior warrior = new Warrior("Siegmeyer of Catarina");
        int actual = warrior.getLevel();

        Assertions.assertEquals(1, actual);
    }

    @Test
    public void levelUp_levelUpNewCharacter_isLevel2() {
        Warrior warrior = new Warrior("Siegmeyer of Catarina");
        warrior.levelUp();
        int actual = warrior.getLevel();

        Assertions.assertEquals(2, actual);
    }

    @Test
    public void totalAttributes_attributesOnCreationForMage_hasCorrectAttributes() {
        Mage mage = new Mage("Yennefer of Vengerberg");
        int str = mage.getTotal().getStrength();
        int dex = mage.getTotal().getDexterity();
        int inte = mage.getTotal().getIntelligence();

        Assertions.assertEquals(1, str);
        Assertions.assertEquals(1, dex);
        Assertions.assertEquals(8, inte);
    }

    @Test
    public void totalAttributes_attributesOnCreationForRanger_hasCorrectAttributes() {
        Ranger ranger = new Ranger("Aragorn");
        int str = ranger.getTotal().getStrength();
        int dex = ranger.getTotal().getDexterity();
        int inte = ranger.getTotal().getIntelligence();

        Assertions.assertEquals(1, str);
        Assertions.assertEquals(7, dex);
        Assertions.assertEquals(1, inte);
    }

    @Test
    public void totalAttributes_attributesOnCreationForRogue_hasCorrectAttributes() {
        Rogue rogue = new Rogue("Ezio Auditore da Firenze");
        int str = rogue.getTotal().getStrength();
        int dex = rogue.getTotal().getDexterity();
        int inte = rogue.getTotal().getIntelligence();

        Assertions.assertEquals(2, str);
        Assertions.assertEquals(6, dex);
        Assertions.assertEquals(1, inte);
    }

    @Test
    public void totalAttributes_attributesOnCreationForWarrior_hasCorrectAttributes() {
        Warrior warrior = new Warrior("Siegmeyer of Catarina");
        int str = warrior.getTotal().getStrength();
        int dex = warrior.getTotal().getDexterity();
        int inte = warrior.getTotal().getIntelligence();

        Assertions.assertEquals(5, str);
        Assertions.assertEquals(2, dex);
        Assertions.assertEquals(1, inte);
    }

    @Test
    public void totalAttributes_attributesOnLevel2ForMage_hasCorrectAttributes() {
        Mage mage = new Mage("Yennefer of Vengerberg");
        mage.levelUp();
        int str = mage.getTotal().getStrength();
        int dex = mage.getTotal().getDexterity();
        int inte = mage.getTotal().getIntelligence();

        Assertions.assertEquals(2, str);
        Assertions.assertEquals(2, dex);
        Assertions.assertEquals(13, inte);
    }

    @Test
    public void totalAttributes_attributesOnLevel2ForRanger_hasCorrectAttributes() {
        Ranger ranger = new Ranger("Aragorn");
        ranger.levelUp();
        int str = ranger.getTotal().getStrength();
        int dex = ranger.getTotal().getDexterity();
        int inte = ranger.getTotal().getIntelligence();

        Assertions.assertEquals(2, str);
        Assertions.assertEquals(12, dex);
        Assertions.assertEquals(2, inte);
    }

    @Test
    public void totalAttributes_attributesOnLevel2ForRogue_hasCorrectAttributes() {
        Rogue rogue = new Rogue("Ezio Auditore da Firenze");
        rogue.levelUp();
        int str = rogue.getTotal().getStrength();
        int dex = rogue.getTotal().getDexterity();
        int inte = rogue.getTotal().getIntelligence();

        Assertions.assertEquals(3, str);
        Assertions.assertEquals(10, dex);
        Assertions.assertEquals(2, inte);
    }

    @Test
    public void totalAttributes_attributesOnLevel2ForWarrior_hasCorrectAttributes() {
        Warrior warrior = new Warrior("Siegmeyer of Catarina");
        warrior.levelUp();
        int str = warrior.getTotal().getStrength();
        int dex = warrior.getTotal().getDexterity();
        int inte = warrior.getTotal().getIntelligence();

        Assertions.assertEquals(8, str);
        Assertions.assertEquals(4, dex);
        Assertions.assertEquals(2, inte);
    }
}