
interface Coffie {
    // void makeCoffie();
    int cost();

    void description();
}

class SimpleCoffie implements Coffie {
    @Override
    public int cost() {
        // System.out.println("Cost of simple coffie is 10");
        return 10;
    }

    @Override
    public void description() {
        System.out.println("This is a simple coffie");
    }

}

abstract class CoffieDecorator implements Coffie {
    protected Coffie coffie;

    public CoffieDecorator(Coffie coffie) {
        this.coffie = coffie;
    }

    @Override
    public int cost() {
        return coffie.cost();
    }

    @Override
    public void description() {
        coffie.description();
    }
}

class MilkDecorator extends CoffieDecorator {
    public MilkDecorator(Coffie coffie) {
        super(coffie);
    }

    @Override
    public int cost() {
        return coffie.cost() + 5;
    }

    @Override
    public void description() {
        super.description();
        System.out.println("Adding milk to the coffie");
    }

}

class SugarDecorator extends CoffieDecorator {
    public SugarDecorator(Coffie coffie) {
        super(coffie);
    }

    @Override
    public int cost() {
        return coffie.cost() + 2;
    }

    @Override
    public void description() {
        coffie.description();
        System.out.println("Adding sugar to the coffie");
    }

}

public class Decorator {
    public static void main(String[] args) {
        Coffie coffie = new SimpleCoffie();
        coffie.description();
        System.out.println("Cost: " + coffie.cost());

        System.out.println("\nAdding milk...");
        coffie = new MilkDecorator(coffie);
        coffie.description();
        System.out.println("Cost: " + coffie.cost());

        System.out.println("\nAdding sugar...");
        coffie = new SugarDecorator(coffie);
        coffie.description();
        System.out.println("Cost: " + coffie.cost());
    }
}
