package fr.ynov.java.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    /*public static void main(String[] args) {
        String fileEmplacement = "src/fr/ynov/java/medium/file.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileEmplacement))) {
            String line;
            System.out.println("Contenu du fichier :");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException err) {
            System.err.println("Erreur lors de la lecture du fichier : " + err.getMessage());
        }
    }*/

    public static void main(String[] args) {
        String directoryEmplacement = "src/fr/ynov/java/medium/filesToRead";

        File directory = new File(directoryEmplacement);
        File[] files = directory.listFiles();

        if (files != null) {
            System.out.println("Contenu des fichiers dans le dossier :");
            for (File file : files) {
                if (file.isFile()) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        System.out.println("Contenu de " + file.getName() + " :");
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException err) {
                        System.err.println("Erreur lors de la lecture du fichier " + file.getName() + " : " + err.getMessage());
                    }
                }
            }
        } else {
            System.err.println("Erreur lors de la lecture du dossier.");
        }
    }
}


