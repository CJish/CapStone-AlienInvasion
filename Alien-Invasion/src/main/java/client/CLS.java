package client;

import java.io.IOException;

public class CLS {
    private static void doClear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void clear() {
        try {
            CLS.doClear();
        } catch (IOException | InterruptedException e) {
            // Handle the exceptions here
            e.printStackTrace(); // or any other appropriate action
        }
    }
}