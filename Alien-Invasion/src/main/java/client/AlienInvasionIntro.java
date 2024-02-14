package client;

import java.io.IOException;

public class AlienInvasionIntro {
    private static final int TypingDelayMs = 50;

    public static void welcome() throws InterruptedException, IOException {

        String story = "Welcome, Space Commander, to the thrilling adventure of 'Alien Invasion.' In this cosmic journey, you will assume the role of the fearless commander of Starship TLG Alactica, embarking on a mission that will challenge your wits and courage. As you decipher signals, navigate interstellar politics, and unveil ancient cosmic secrets, the destiny of humanity will rest in your hands. Are you ready to embark on this epic quest to shape the future of our world?";

        String objective = "Your objective is to explore the the Starship uncovering hidden mysteries and puzzles.  You will be tasked to solve various problems, puzzles, and mysteries that will ultimately shape the destiny of humanity.";

        String playerIdentity = "As the Space Commander of Starship TLG Alactica, you are humanity's last hope.";

        String winGame = "In order to achieve victory in the game, you must skillfully tackle challenges, riddles, and clues that culminate in an ultimate confrontation between humanity and the impending alien invasion!";

        clearConsole();
        printWithTypewriterEffect(story);
        clearConsolePause(1000);
        printWithTypewriterEffect(objective);
        clearConsolePause(1000);
        printWithTypewriterEffect(playerIdentity);
        clearConsolePause(1000);
        printWithTypewriterEffect(winGame);
        System.out.println("Press enter to continue");
    }

    private static void printWithTypewriterEffect(String text) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            Thread.sleep(TypingDelayMs);
        }
        System.out.println("\n");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void clearConsolePause(int ClearDelayMs){
        try {
            Thread.sleep(ClearDelayMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CLS.clear();
    }
}