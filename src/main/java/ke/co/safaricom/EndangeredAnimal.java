package ke.co.safaricom;

public class EndangeredAnimal {
    public EndangeredAnimal(String name, int id, boolean endangered, String health, String age) {
        this.name = name;
        this.id = id;
        this.endangered = endangered;
        this.health = health;
        this.age = age;
    }

    public static Object all() {
        return null;
    }

    public static Animal find(int animalIdSelected) {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEndangered() {
        return endangered;
    }

    public void setEndangered(boolean endangered) {
        this.endangered = endangered;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String name;
    public int id;
    public boolean endangered;
    private String health;
    private String age;
}
