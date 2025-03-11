package fr.ynov.java.medium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String fileEmplacement = "src/fr/ynov/java/medium/file.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileEmplacement));
        String line;
        System.out.println("Contenu du fichier :");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
