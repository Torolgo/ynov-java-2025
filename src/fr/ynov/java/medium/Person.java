package fr.ynov.java.medium;

import java.time.LocalDate;
import java.time.Period;

public class  Person {
    private final String name;
    private final String birthDate;
    private final String gender;
    private final float height;
    private final float weight;
    private static Nationality nationality;

    public Person(String name, String birthDate, String gender, float height, float weight, Nationality nationality) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        Person.nationality = nationality;
    };

    public static LocalDate strToLocalDate(String date) {
        return LocalDate.parse(date);
    };

    public int age(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    };

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age(strToLocalDate(birthDate)) );
        System.out.println("Gender: " + gender);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("Nationality: " + nationality);
    }

    public static void main(String[] args) {
        Person person = new Person("John", "1956-01-05", "F", 1.75f, 75.0f, nationality.FRENCH);
        person.display();
    }
}
