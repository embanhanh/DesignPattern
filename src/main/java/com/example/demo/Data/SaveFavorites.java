package com.example.demo.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SaveFavorites {
    public static String filePath = "src/main/java/com/example/demo/Data/favorites.txt ";

    public static void addFavorite(String pattern) {
        try {
            Path path = Paths.get(filePath);
            List<String> favorites;

            if (Files.exists(path)) {
                favorites = Files.readAllLines(path);
            } else {
                favorites = new ArrayList<>();
            }

            favorites.add(pattern);
            Files.createDirectories(path.getParent());
            Files.write(path, favorites);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getFavorites() {
        try {
            Path path = Paths.get(filePath);

            if (Files.exists(path)) {
                return Files.readAllLines(path);
            } else {
                System.out.println("File " + filePath + " does not exist.");
                return new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void removeFavorite(String pattern) {
        try {
            Path path = Paths.get(filePath);
            List<String> designPatterns;

            if (Files.exists(path)) {
                designPatterns = Files.readAllLines(path);
            } else {
                designPatterns = new ArrayList<>();
            }

            if (designPatterns.remove(pattern)) {
                Files.createDirectories(path.getParent());
                Files.write(path, designPatterns);
                System.out.println("Removed and saved to " + filePath);
            } else {
                System.out.println("Pattern not found: " + pattern);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
