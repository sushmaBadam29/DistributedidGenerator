import java.time.Instant;

public class idTask implements Runnable{
    int count=0;
    @Override
    public void run() {
        System.out.println(Instant.now().toEpochMilli()+"@"+Thread.currentThread().getName()+"@"+count++);

    }
}
