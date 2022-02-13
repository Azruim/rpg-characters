package com.assignment1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    public void characterConstructor_characterCreation_isLevel1() {
        Warrior warrior = new Warrior("Siegmeyer of Catarina");
        int level = warrior.level;
        Assertions.assertEquals(1, level);
    }

    @Test
    public void levelUp_levelUpNewCharacter_isLevel2() {
        Warrior warrior = new Warrior("Siegmeyer of Catarina");
        warrior.levelUp();
        int level = warrior.level;
        Assertions.assertEquals(2, level);
    }

    @Test
    public void totalAttributes_attributesOnCreationForMage_hasCorrectAttributes() {
        Mage mage = new Mage("Yennefer of Vengerberg");
        int str = mage.total.getStrength();
        int dex = mage.total.getDexterity();
        int inte = mage.total.getIntelligence();
        Assertions.assertEquals(1, str);
        Assertions.assertEquals(1, dex);
        Assertions.assertEquals(8, inte);
    }

    @Test
    public void totalAttributes_attributesOnCreationForRanger_hasCorrectAttributes() {
        Ranger ranger = new Ranger("Aragorn");
        int str = ranger.total.getStrength();
        int dex = ranger.total.getDexterity();
        int inte = ranger.total.getIntelligence();
        Assertions.assertEquals(1, str);
        Assertions.assertEquals(7, dex);
        Assertions.assertEquals(1, inte);
    }

    @Test
    public void totalAttributes_attributesOnCreationForRogue_hasCorrectAttributes() {
        Rogue rogue = new Rogue("Ezio Auditore da Firenze");
        int str = rogue.total.getStrength();
        int dex = rogue.total.getDexterity();
        int inte = rogue.total.getIntelligence();
        Assertions.assertEquals(2, str);
        Assertions.assertEquals(6, dex);
        Assertions.assertEquals(1, inte);
    }

    @Test
    public void totalAttributes_attributesOnCreationForWarrior_hasCorrectAttributes() {
        Warrior warrior = new Warrior("Siegmeyer of Catarina");
        int str = warrior.total.getStrength();
        int dex = warrior.total.getDexterity();
        int inte = warrior.total.getIntelligence();
        Assertions.assertEquals(5, str);
        Assertions.assertEquals(2, dex);
        Assertions.assertEquals(1, inte);
    }

    @Test
    public void totalAttributes_attributesOnLevel2ForMage_hasCorrectAttributes() {
        Mage mage = new Mage("Yennefer of Vengerberg");
        mage.levelUp();
        int str = mage.total.getStrength();
        int dex = mage.total.getDexterity();
        int inte = mage.total.getIntelligence();
        Assertions.assertEquals(2, str);
        Assertions.assertEquals(2, dex);
        Assertions.assertEquals(13, inte);
    }

    @Test
    public void totalAttributes_attributesOnLevel2ForRanger_hasCorrectAttributes() {
        Ranger ranger = new Ranger("Aragorn");
        ranger.levelUp();
        int str = ranger.total.getStrength();
        int dex = ranger.total.getDexterity();
        int inte = ranger.total.getIntelligence();
        Assertions.assertEquals(2, str);
        Assertions.assertEquals(12, dex);
        Assertions.assertEquals(2, inte);
    }

    @Test
    public void totalAttributes_attributesOnLevel2ForRogue_hasCorrectAttributes() {
        Rogue rogue = new Rogue("Ezio Auditore da Firenze");
        rogue.levelUp();
        int str = rogue.total.getStrength();
        int dex = rogue.total.getDexterity();
        int inte = rogue.total.getIntelligence();
        Assertions.assertEquals(3, str);
        Assertions.assertEquals(10, dex);
        Assertions.assertEquals(2, inte);
    }

    @Test
    public void totalAttributes_attributesOnLevel2ForWarrior_hasCorrectAttributes() {
        Warrior warrior = new Warrior("Siegmeyer of Catarina");
        warrior.levelUp();
        int str = warrior.total.getStrength();
        int dex = warrior.total.getDexterity();
        int inte = warrior.total.getIntelligence();
        Assertions.assertEquals(8, str);
        Assertions.assertEquals(4, dex);
        Assertions.assertEquals(2, inte);
    }
}