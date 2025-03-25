package fr.ynov.java.game;

import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Player {
    private String name;
    private int victories;
    private int defeats;
    private Dictionary<String, Integer> scores;
    private JSONObject jsonObject = new JSONObject();

    public Player(String name) {
        this.name = name;
        this.victories = 0;
        this.defeats = 0;
        this.scores = new Hashtable<>();
        this.loadScore();
    }

    public String getName() {
        return name;
    }

    public void askName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        this.setName(name);
        this.loadScore();
        System.out.println("Hello " + this.getName() + "!");
    }

    public Dictionary<String, Integer> getScore() {
        return this.scores;
    }

    public void addScore(int score) {
        if (score < 0) {
            this.defeats++;
        } else {
            this.victories++;
        }
    }

    public void resetScore() {
        this.victories = 0;
        this.defeats = 0;
    }

    public void saveScore() {
        this.scores.put("victories", this.victories);
        this.scores.put("defeats", this.defeats);

        try{
            File directory = new File("./src/fr/ynov/java/game/saves");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File file = new File("./src/fr/ynov/java/game/saves/player-saves.json");
            if (file.exists() && file.length() > 0) {
                Scanner scanner = new Scanner(file);
                StringBuilder jsonContent = new StringBuilder();
                while (scanner.hasNextLine()) {
                    jsonContent.append(scanner.nextLine());
                }
                scanner.close();
                jsonObject = new JSONObject(jsonContent.toString());
            }
            jsonObject.put(this.name, this.scores);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonObject.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Score saved!");
    }

    public void loadScore() {
        try {
            File file = new File("./src/fr/ynov/java/game/saves/player-saves.json");
            if (file.exists() && file.length() > 0) {
                Scanner scanner = new Scanner(file);
                StringBuilder jsonContent = new StringBuilder();
                while (scanner.hasNextLine()) {
                    jsonContent.append(scanner.nextLine());
                }
                scanner.close();
                jsonObject = new JSONObject(jsonContent.toString());
                if (jsonObject.has(this.name)) {
                    JSONObject playerScores = jsonObject.getJSONObject(this.name);
                    this.victories = playerScores.getInt("victories");
                    this.defeats = playerScores.getInt("defeats");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayScore(){
        System.out.println("The player " + this.name + " has : \n" +
                this.victories + " Victories\n" +
                this.defeats + " Defeats");
    }

    public void setName(String name) {
        this.name = name;
    }
}
