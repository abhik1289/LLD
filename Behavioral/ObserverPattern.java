import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String message);
}

class YoutubeChannel implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void uploadVideo(String videoTitle) {
        System.out.println("Uploading video: " + videoTitle);
        notifyObservers("New video uploaded: " + videoTitle);
    }
}

class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String message) {
        System.out.println(appName + " received notification: " + message);
    }
}

class EmailNotification implements Observer {
    private String email;

    public EmailNotification(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Email sent to " + email + ": " + message);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel();
        Observer u1 = new MobileApp("YouTube Mobile App");
        Observer u2 = new EmailNotification("user@example.com");
        channel.registerObserver(u1);
        channel.registerObserver(u2);
        channel.uploadVideo("Java Observer Pattern Tutorial");
    }
}
