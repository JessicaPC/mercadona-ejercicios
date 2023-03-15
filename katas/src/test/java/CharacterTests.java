import com.mercadona.rpg.Character;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTests {

    @Test
    void whenCreatedCharacterMustHave1000Health() {
        Character character = new Character();
        assertEquals(1000, character.getHealth());
    }

    @Test
    void whenCreatedCharacterMustHaveLevel1(){
        Character character = new Character();
        assertEquals(1, character.getLevel());
    }

    @Test
    void whenCreatedCharacterMustBeAlive(){
        Character character = new Character();
        assertTrue(character.isAlive());
    }

    @Test
    void whenCharacterDoDamage(){
        //given
        Character character = new Character();
        Character characterDamaged = new Character();
        characterDamaged.setHealth(100);
        //when
        character.doDamage(10, characterDamaged);
        //then
        assertEquals(90, characterDamaged.getHealth());
    }

    @Test
    void whenCharacterDies(){
        Character character = new Character();
        Character characterDamaged = new Character();

        characterDamaged.setHealth(100);
        character.doDamage(200, characterDamaged);
        assertFalse(characterDamaged.isAlive());
    }

    @Test
    void whenCharacterDoHeal(){
        Character character = new Character();
        character.setHealth(700);
        character.doHeal(200, character);
        assertEquals(900, character.getHealth());
    }

    @Test
    void whenCharacterCantHeal(){
        Character character = new Character();
        character.setHealth(1000);
        character.doHeal(200, character);
        assertEquals(1000, character.getHealth());
    }

    @Test
    void whenCharacterCantHealOtherCharacter(){
        Character character = new Character();
        Character character2 = new Character();
        character2.setHealth(1000);
        character.doHeal(200, character2);
        assertEquals(1000, character2.getHealth());
    }

    @Test
    void whenDeadCharacterCantHeal(){
        Character character = new Character();
        character.setAlive(false);
        character.doHeal(200, character);
        assertEquals(0, character.getHealth());
    }
}
