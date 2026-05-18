
class DvDPlayer {
    public void play() {
        System.out.println("Playing DVD...");
    }
}

class Projector {
    public void project() {
        System.out.println("Projecting DVD...");
    }
}

class Lights {
    public void on() {
        System.out.println("Turning on the lights...");
    }
}

class Volume {
    public void up() {
        System.out.println("Increasing volume...");
    }

    public void down() {
        System.out.println("Decreasing volume...");
    }
}

class HomeTheaterFacade {
    private DvDPlayer dvdPlayer;
    private Projector projector;
    private Lights lights;
    private Volume volume;

    public HomeTheaterFacade() {
        this.dvdPlayer = new DvDPlayer();
        this.projector = new Projector();
        this.lights = new Lights();
        this.volume = new Volume();
    }

    public void watchMovie() {
        System.out.println("Get ready to watch a movie...");
        lights.on();
        projector.project();
        dvdPlayer.play();
        volume.up();
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        volume.down();
        projector.project();
        lights.on();
    }
}

public class Facade {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        homeTheater.watchMovie();

    }
}
