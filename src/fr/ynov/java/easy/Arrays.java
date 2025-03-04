package fr.ynov.java.easy;

public class Arrays {
    public static void main(String[] args) {
        int[] tab = new int[10];
        for (int x = 0; x < 10; x++) {
            tab[x] = x+1;
        }
        //for standard
        for (int x = 0; x < 10; x++) {
            System.out.println(tab[x]);
        }
        //for modern
        for (int x : tab) {
            System.out.println(x);
        }
    }
}
