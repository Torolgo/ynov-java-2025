package fr.ynov.java.game;

import org.json.JSONObject;

import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

public class Game  {

    private final Dictionary<Integer, String> choices;
    private Player player;

    public Game() {
        this.choices = new Hashtable<>();
        this.choices.put(1, "Rock");
        this.choices.put(2, "Scissors");
        this.choices.put(3, "Paper");
        this.player = new Player("Player");
    }

    public void displayScoreboard(){
        try {
            File file = new File("./src/fr/ynov/java/game/saves/player-saves.json");

            if (file.exists() && file.length() > 0) {
                Scanner scanner = new Scanner(file);
                StringBuilder jsonContent = new StringBuilder();
                while (scanner.hasNextLine()) {
                    jsonContent.append(scanner.nextLine());
                }
                scanner.close();
                JSONObject jsonObject = new JSONObject(jsonContent.toString());
                System.out.println("Scoreboard:");
                for (String name : jsonObject.keySet()) {
                    JSONObject player = jsonObject.getJSONObject(name);
                    int victories = player.getInt("victories");
                    int defeats = player.getInt("defeats");
                    System.out.println(name + " - Victories: " + victories + ", Defeats: " + defeats);
                }
            } else {
                System.out.println("No scores saved yet.");
            }
        }catch (Exception e){
            System.err.println("Error while reading the file : " + e.getMessage());
        }
    }

    public void manageGameSession() {
        boolean playing = true;
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (playing){
            System.out.println("Please choose an action : \n" +
                    "[1] Rock \n" +
                    "[2] Scissors \n" +
                    "[3] Paper \n" +
                    "[4] My score \n" +
                    "[5] Reset my score \n" +
                    "[6] Scoreboard \n" +
                    "[7] Save and Exit");
            choice = scanner.nextInt();
            Random rand = new Random();
            int computerChoice = rand.nextInt(3)+1;
            if (choice <= 3){
                if (choice == computerChoice){
                    System.out.println("The Computer chose " + this.choices.get(computerChoice) + "\n" +
                            "It's a tie!");
                } else if (computerChoice > choice && computerChoice - choice == 1 || computerChoice < choice && choice - computerChoice == 2) {
                    this.player.addScore(1);
                    System.out.println("The Computer chose " + this.choices.get(computerChoice) + "\n" +
                            "You win!");
                } else if (computerChoice < choice && choice - computerChoice == 1 || choice < computerChoice && computerChoice - choice == 2) {
                    this.player.addScore(-1);
                    System.out.println("The Computer chose " + this.choices.get(computerChoice) + "\n" +
                            "You lose!");
                }
            }else {
                switch (choice){
                    case 4:
                        this.player.displayScore();
                        break;
                    case 5:
                        this.player.resetScore();
                        this.player.displayScore();
                        break;
                    case 6:
                        this.displayScoreboard();
                        break;
                    case 7:
                        this.player.saveScore();
                        playing = false;
                        break;
                }
            }
        }
    }

    public void run() {
        System.out.println("Welcome to the game!");
        this.displayScoreboard();
        this.player.askName();
        this.manageGameSession();
    }
}