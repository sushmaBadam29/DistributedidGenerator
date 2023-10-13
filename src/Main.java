import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
//        ExecutorService executor2 = Executors.newFixedThreadPool(5);
//        ExecutorService executor3 = Executors.newFixedThreadPool(5);
//        ExecutorService executor4 = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 20; i++) {
            Task task = new Task(i);
            executor.execute(task);
//            executor2.execute(task);
//            executor3.execute(task);
//            System.out.println("-----------------------------------------------------------");
//            idTask t=new idTask();
//            executor4.execute(t);
        }
        shutdownAndAwaitTermination(executor);
//        shutdownAndAwaitTermination(executor2);
//        shutdownAndAwaitTermination(executor3);
//        shutdownAndAwaitTermination(executor4);

        String str="sdfvsdf68fsdfsf8999fsdf09";
        List<String> tokens = Arrays.stream(str.split("\\D+")).filter(s -> s.length() > 0).collect(Collectors.toList());
        System.out.println(tokens);
    }
    static void shutdownAndAwaitTermination(ExecutorService pool) {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow();
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ex) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}