# Q5. Explain How Threads Could Be Implemented Using Runnable Interface

## Why Runnable?

Java supports two ways to create threads:
1. Extending `Thread` class
2. Implementing `Runnable` interface ← **preferred approach**

Since Java does not support multiple inheritance, implementing `Runnable` is preferred because your class can still extend another class.

## Steps to Create a Thread Using Runnable

1. Create a class that **implements `Runnable`**
2. Override the **`run()`** method with the task logic
3. Create a **`Thread`** object by passing the `Runnable` instance
4. Call **`start()`** on the Thread object

## Example

```java
import java.lang.*;

// Step 1 & 2: Implement Runnable and override run()
class Task implements Runnable {
    String taskName;

    Task(String name) {
        this.taskName = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " - count: " + i
                    + " [" + Thread.currentThread().getName() + "]");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted");
            }
        }
        System.out.println(taskName + " completed.");
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Task t1 = new Task("DownloadTask");
        Task t2 = new Task("UploadTask");

        // Step 3: Wrap in Thread
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);

        thread1.setName("Thread-Download");
        thread2.setName("Thread-Upload");

        // Step 4: Start threads
        thread1.start();
        thread2.start();
    }
}
```

## Runnable vs Thread (Comparison)

| Feature | `implements Runnable` | `extends Thread` |
|---------|-----------------------|------------------|
| Inheritance | Class can extend others | No multiple inheritance |
| Object reuse | Same Runnable for multiple threads | One thread per object |
| Separation of concern | Task logic separate from thread | Mixed |
| **Preferred** | ✅ Yes | ❌ Less preferred |
