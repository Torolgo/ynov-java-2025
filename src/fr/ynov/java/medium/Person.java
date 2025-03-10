package fr.ynov.java.medium;

public class Person {
    private final String name;
    private final String gender;
    private final float height;
    private final float weight;
    private static nationality nationality;
    private final int age;

    public enum nationality {
        FRENCH("French"),
        ENGLISH("English"),
        GERMAN("German"),
        ITALIAN("Italian"),
        SPANISH("Spanish");
        final String nationality;
        nationality(String Country) {
            this.nationality = Country;
        };
        public String getNationality() {
            return nationality;
        }
    };

    public Person(String name, int age, String gender, float height, float weight, nationality nationality) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        Person.nationality = nationality;
    };

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("Nationality: " + nationality.getNationality());
    }

    public static void main(String[] args) {
        Person person = new Person("John", 25, "F", 1.75f, 75.0f, nationality.FRENCH);
        person.display();

    }
}
