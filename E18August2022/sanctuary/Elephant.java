package sanctuary;

public class Elephant {
    private String name;
    private int age;
    private String retiredFrom;

    public Elephant(String name, int age, String retiredFrom) {
        this.name = name;
        this.age = age;
        this.retiredFrom = retiredFrom;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRetiredFrom() {
        return retiredFrom;
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s", name, age, retiredFrom);
    }
}
