
interface TrafficLightState {
    void action();
}

class RedState implements TrafficLightState {
    @Override
    public void action() {
        System.out.println("Red Light: Stop!");
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void action() {
        System.out.println("Green Light: Go!");
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void action() {
        System.out.println("Yellow Light: Caution!");
    }
}

class TrafficSignal {
    private TrafficLightState currentState;

    TrafficSignal(TrafficLightState state) {
        this.currentState = state;
    }

    public void showSignal() {
        currentState.action();
    }
}

public class StatePattern {
    public static void main(String[] args) {

        TrafficSignal trafficSignal = new TrafficSignal(new YellowState());
        // trafficSignal.setState(new GreenState());
        trafficSignal.showSignal();

    }
}
