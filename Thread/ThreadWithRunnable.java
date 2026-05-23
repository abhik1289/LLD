
class WhatsappMsg implements Runnable {
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

class FacebookMsg implements Runnable {
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

class SMSMsg implements Runnable {
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

public class ThreadWithRunnable {
    public static void main(String[] args) {
        WhatsappMsg whatsapp = new WhatsappMsg();
        FacebookMsg facebook = new FacebookMsg();
        SMSMsg sms = new SMSMsg();

        Thread whatsappThread = new Thread(whatsapp);
        Thread facebookThread = new Thread(facebook);
        Thread smsThread = new Thread(sms);

        // executing it parallelly
        whatsappThread.start();
        facebookThread.start();
        smsThread.start();
    }
}
