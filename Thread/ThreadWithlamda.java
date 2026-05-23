
public class ThreadWithlamda {
    public static void main(String[] args) {
        Thread whatsapp = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate some delay
                System.out.println("This is a message from Whatsapp");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
};
