package fr.ynov.java.medium;

import java.io.*;

public class WriteFile {
    public static StringBuilder readingFile() {
        String fileEmplacement = "src/fr/ynov/java/medium/filesToRead/file.txt";
        StringBuilder file = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileEmplacement))) {
            String line;
            while ((line = reader.readLine()) != null) {
                file.append(line).append("\n");
            }
        } catch (IOException err) {
            System.err.println("Erreur lors de la lecture du fichier : " + err.getMessage());
        }
        return file;
    }
    public static void writeFile(StringBuilder content) {
        String fileName = "src/fr/ynov/java/medium/fileWrited.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.valueOf(content));
            System.out.println("Le fichier a été créé et le texte a été écrit.");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        StringBuilder content = readingFile();
        writeFile(content);
    }
}