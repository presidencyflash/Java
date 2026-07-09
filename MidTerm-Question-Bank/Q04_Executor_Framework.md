# Q4. Explain Executor Framework with respect to Producer-Consumer Pattern

## What is the Executor Framework?

The **Executor Framework** (`java.util.concurrent`) was introduced in Java 5 to simplify thread management. Instead of manually creating and managing threads, you submit **tasks** to an **ExecutorService** which manages a **thread pool** internally.

**Key interfaces/classes:**

| Class/Interface | Role |
|-----------------|------|
| `Executor` | Base interface with `execute(Runnable)` |
| `ExecutorService` | Extends Executor; supports `submit()`, `shutdown()` |
| `Executors` | Factory class to create thread pools |
| `Future<T>` | Represents result of an async computation |
| `BlockingQueue` | Thread-safe queue used in Producer-Consumer |

## Thread Pool Types

```java
ExecutorService pool1 = Executors.newFixedThreadPool(4);     // fixed number of threads
ExecutorService pool2 = Executors.newCachedThreadPool();     // grows/shrinks as needed
ExecutorService pool3 = Executors.newSingleThreadExecutor(); // single background thread
ExecutorService pool4 = Executors.newScheduledThreadPool(2); // for scheduled tasks
```

## Producer-Consumer Using Executor + BlockingQueue

```java
import java.util.concurrent.*;

public class ExecutorProducerConsumer {

    static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

    static Runnable producer = () -> {
        try {
            for (int i = 1; i <= 10; i++) {
                queue.put(i); // blocks if queue is full
                System.out.println("Produced: " + i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {}
    };

    static Runnable consumer = () -> {
        try {
            for (int i = 1; i <= 10; i++) {
                int val = queue.take(); // blocks if queue is empty
                System.out.println("Consumed: " + val);
                Thread.sleep(400);
            }
        } catch (InterruptedException e) {}
    };

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(producer);
        executor.submit(consumer);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
```

## Why Use Executor over raw Threads?

| Raw Threads | Executor Framework |
|------------|-------------------|
| Manual thread creation/management | Automated thread pooling |
| Hard to control thread count | Easy to set pool size |
| No reuse of threads | Threads are reused |
| Harder error handling | `Future` for exception handling |
