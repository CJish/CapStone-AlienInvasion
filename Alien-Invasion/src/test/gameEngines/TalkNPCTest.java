package gameEngines;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TalkNPCTest {
    @Before
    public void init() {}

    @Test
    public void talkWithNpcShouldNotBeNull() {
        assertNotEquals(TalkNPC.handleTalkWithNpc("Alien-queen"), "not found");
    }
}