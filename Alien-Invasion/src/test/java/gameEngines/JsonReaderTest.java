package gameEngines;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {
    List<String> userInputNpc = new ArrayList<>();

    @Before
    public void init() {
        userInputNpc.add("talk");
        userInputNpc.add("captain-pikeman");
    }

    @Test
    public void jsonReaderShouldReturnNpcAndNotBeNull() {
        assertNotNull(JsonReader.returnNpc("CAPTAIN-PIKEMAN"));
    }

    @Test
    public void jsonReaderShouldReturnNull_withInvalidNpcName() {
        assertNull(JsonReader.returnNpc("BillyBob"));
    }

    @Test
    public void nounJsonShouldReturnMatchingString() {
        String targetString = "captain-pikeman";

        String retrievedString = JsonReader.readNounJson(userInputNpc);

        assertEquals(retrievedString, targetString);
    }

    @Test
    public void characters_shouldNotBeNull_orEmpty_ifCharactersPresentInLocation() {
        List<String> characters = JsonReader.getLocationByName("Mystery Room").getCharacters();
        assertNotNull(characters);

    }
}