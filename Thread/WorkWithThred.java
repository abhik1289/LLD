import java.util.*;

class WhatsappMessage extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000); // Simulate some delay
            System.out.println("This is a message from Whatsapp");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class FacebookMessage extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(4000); // Simulate some delay
            System.out.println("This is a message from Facebook");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SMSMessage extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(2000); // Simulate some delay
            System.out.println("This is a message from SMS");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class WorkWithThred {
    public static void main(String[] args) {
        WhatsappMessage whatsapp = new WhatsappMessage();
        FacebookMessage facebook = new FacebookMessage();
        SMSMessage sms = new SMSMessage();

        // executing it parallelly
        whatsapp.start();
        facebook.start();
        sms.start();

    }
}
