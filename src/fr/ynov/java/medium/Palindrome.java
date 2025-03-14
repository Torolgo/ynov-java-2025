package fr.ynov.java.medium;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        String formatedWord = word.replaceAll(" ", "").toLowerCase();
        StringBuilder formatedWordRev = new StringBuilder(formatedWord).reverse();
        return formatedWord.contentEquals(formatedWordRev);
    }

    public static void main(String[] args) {
        String word = "Engage le jeu que je le gagne";
        if (isPalindrome(word)) {
            System.out.println("Le mot " + word + " est un palindrome.");
        } else {
            System.out.println("Le mot " + word + " n'est pas un palindrome.");
        }
    }
}
