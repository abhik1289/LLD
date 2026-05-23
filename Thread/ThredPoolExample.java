
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//DAO CLASS
// REPOSITORY CLASS
public class ThredPoolExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }

}
