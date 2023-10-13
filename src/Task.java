import lombok.SneakyThrows;

import java.time.Instant;
import java.time.LocalDateTime;

class Task implements Runnable {
    private final int count;
    public Task(int count) {
        this.count = count;
    }
    @Override
    public void run() {
        System.out.println(Instant.now().toEpochMilli()+"@"+Thread.currentThread().getName()+"@"+count);
    }
}