package fr.ynov.java.medium;

public class Quality {
    int id ;
    String name;

    public Quality(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Quality quality) {
            return quality.id == this.id && quality.name.equals(this.name);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return id + name.hashCode();
    }

    public static void main(String[] args) {
        Quality quality1 = new Quality(1, "Good");
        Quality quality2 = new Quality(1, "Good");
        System.out.println(quality1.equals(quality2));
        System.out.println(quality1.hashCode() == quality2.hashCode());
    }
}
