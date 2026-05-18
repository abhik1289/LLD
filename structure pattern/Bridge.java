interface TV {
    void on();

    void off();

    void tuneChannel(int channel);
}

class SonyTV implements TV {

    @Override
    public void on() {
        System.out.println("Sony TV ON");
    }

    @Override
    public void off() {
        System.out.println("Sony TV OFF");
    }

    @Override
    public void tuneChannel(int channel) {
        System.out.println(
                "Sony TV tuned to channel " + channel);
    }
}

class SamsungTV implements TV {

    @Override
    public void on() {
        System.out.println("Samsung TV ON");
    }

    @Override
    public void off() {
        System.out.println("Samsung TV OFF");
    }

    @Override
    public void tuneChannel(int channel) {
        System.out.println(
                "Samsung TV tuned to channel " + channel);
    }
}

abstract class RemoteControl {

    protected TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    abstract void turnOn();

    abstract void turnOff();
}

class BasicRemote extends RemoteControl {

    public BasicRemote(TV tv) {
        super(tv);
    }

    @Override
    void turnOn() {
        tv.on();
    }

    @Override
    void turnOff() {
        tv.off();
    }

    public void setChannel(int channel) {
        tv.tuneChannel(channel);
    }
}

public class Bridge {

    public static void main(String[] args) {
        TV sony = new SonyTV();
        RemoteControl remote1 = new BasicRemote(sony);

        remote1.turnOn();

        TV samsung = new SamsungTV();
        BasicRemote remote2 = new BasicRemote(samsung);

        remote2.turnOn();
        remote2.setChannel(5);
    }

}
