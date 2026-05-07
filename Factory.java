
interface Logistics {
    void send();
}

// payment gateway, Notification service
class Road implements Logistics {

    @Override
    public void send() {
        System.out.println("Road Logistics");
    }
}

class Air implements Logistics {

    @Override
    public void send() {
        System.out.println("Air Logistics");
    }

}

class Logisticfactory {

    public static Logistics getLogistics(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("ROAD")) {
            return new Road();
        }
        return new Air();

    }

}

class LogisticsService {

    public void send(String type) {
        Logistics logistics = Logisticfactory.getLogistics(type);
        logistics.send();

    }

}

public class Factory {
    public static void main(String[] args) {
        System.out.println("Factory Pattern Implementation");
    }

}
