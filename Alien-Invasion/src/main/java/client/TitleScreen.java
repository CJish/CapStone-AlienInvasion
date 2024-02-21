package client;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TitleScreen {

    public static void displayAsciiArt(String filePath) {
        try {
            // Read the ASCII art from the file
            String asciiArt = readAsciiArt(filePath);

            // Display the ASCII art
            System.out.println(asciiArt);
        } catch (IOException e) {
            System.err.println("Error reading ASCII art file: " + e.getMessage());
        }
    }

    private static String readAsciiArt(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}

