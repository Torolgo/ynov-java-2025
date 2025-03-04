package fr.ynov.java.easy;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        float num1 = Float.parseFloat(args[0]);
        float num2 = Float.parseFloat(args[1]);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter what operation you want to perform: ");
        String operation = sc.nextLine();
        switch (operation) {
            case "+":
                System.out.println(num1 + num2);
                break;
            case "-":
                System.out.println(num1 - num2);
                break;
            case "*":
                System.out.println(num1 * num2);
                break;
            case "/":
                System.out.println(num1 / num2);
                break;
            default:
                System.out.println("Invalid operation");
        }

    }
}
