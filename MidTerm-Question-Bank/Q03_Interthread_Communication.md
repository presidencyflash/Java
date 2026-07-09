# Q3. Explain Inter-thread Communication

## What is Inter-thread Communication?

Inter-thread communication (also called **cooperation**) allows synchronized threads to communicate with each other to avoid **polling** (busy-waiting). It uses three key methods defined in `java.lang.Object`:

| Method | Description |
|--------|-------------|
| `wait()` | Releases the lock and puts the current thread in WAITING state |
| `notify()` | Wakes up one thread that is waiting on the same object's lock |
| `notifyAll()` | Wakes up all threads waiting on the same object's lock |

> These methods must be called from within a **synchronized context**, otherwise `IllegalMonitorStateException` is thrown.

## Classic Producer-Consumer Example

```java
class SharedBox {
    int item;
    boolean hasItem = false;

    synchronized void produce(int val) throws InterruptedException {
        while (hasItem) {
            wait(); // wait until consumer takes the item
        }
        item = val;
        hasItem = true;
        System.out.println("Produced: " + val);
        notify(); // notify the consumer
    }

    synchronized int consume() throws InterruptedException {
        while (!hasItem) {
            wait(); // wait until producer adds an item
        }
        hasItem = false;
        System.out.println("Consumed: " + item);
        notify(); // notify the producer
        return item;
    }
}

public class InterThreadDemo {
    public static void main(String[] args) {
        SharedBox box = new SharedBox();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) box.produce(i);
            } catch (InterruptedException e) {}
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) box.consume();
            } catch (InterruptedException e) {}
        });

        producer.start();
        consumer.start();
    }
}
```

## Flow Summary

```
Producer --> produce() --> notify() consumer --> Consumer wakes up
Consumer --> consume() --> notify() producer --> Producer wakes up
```
