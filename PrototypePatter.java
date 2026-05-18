
interface Prototype {
    Prototype clone();
}

class Car implements Prototype {
    private String id;
    private String type;

    public Car(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Prototype clone() {
        return new Car(this.id, this.type);
    }

    public void display() {
        System.out.println("Car ID: " + id + ", Type: " + type);
    }
}

public class PrototypePatter {
    public static void main(String[] args) {
        Car originalCar = new Car("123", "Sedan");
        System.out.println("Original Car:");
        originalCar.display();

        Car clonedCar = (Car) originalCar.clone();
        System.out.println("Cloned Car:");
        clonedCar.display();

        // Modifying the cloned car's ID to show that it's a separate instance
        clonedCar.setId("456");
        System.out.println("After modifying the cloned car's ID:");
        System.out.println("Original Car:");
        originalCar.display();
        System.out.println("Cloned Car:");
        clonedCar.display();
    }
}
