package fr.ynov.java.medium;

import java.util.Scanner;

public class Square {
//    public static void main(String[] args) {
//        System.out.println(square());
//    }
//    public static int square() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a number: ");
//        int x = sc.nextInt();
//        System.out.println("Your number squared is: ");
//        return x * x;
//    }
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square.square());
    }
    public int square() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int x = sc.nextInt();
        System.out.println("Your number squared is: ");
        return x * x;
    }

}

