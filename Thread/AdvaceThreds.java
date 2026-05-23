import java.util.*;
import java.util.concurrent.*;

class MyTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 42;
    }
}

public class AdvaceThreds {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new MyTask());
        try {
            Integer result = future.get(); // This will block until the result is available
            System.out.println("Result from MyTask: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }
}