# Q2. Explain Thread Synchronization

## What is Thread Synchronization?

When multiple threads access a **shared resource** (e.g., a variable, file, or object) simultaneously, it can lead to **data inconsistency** or **race conditions**. Thread synchronization is the mechanism that ensures **only one thread can access a critical section at a time**.

Java uses the concept of a **monitor lock** (also called intrinsic lock) to achieve synchronization.

## Race Condition (Problem without Synchronization)

```java
class Counter {
    int count = 0;
    void increment() { count++; } // NOT thread-safe
}
```
If two threads call `increment()` at the same time, both may read the same `count` value and write back the same incremented value — losing one increment.

## Synchronized Keyword (Solution)

Java provides the `synchronized` keyword in two ways:

### 1. Synchronized Method
```java
class Counter {
    int count = 0;
    synchronized void increment() {
        count++; // only one thread at a time
    }
}
```

### 2. Synchronized Block (more granular control)
```java
class Resource {
    void use(String name) {
        System.out.print("[" + name);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println("]");
    }
}

class MyThread extends Thread {
    Resource r;
    String name;
    MyThread(String name, Resource r) {
        this.name = name;
        this.r = r;
    }
    public void run() {
        synchronized (r) {   // lock on shared resource object
            r.use(name);
        }
    }
}

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        Resource res = new Resource();
        MyThread t1 = new MyThread("1st", res);
        MyThread t2 = new MyThread("2nd", res);
        MyThread t3 = new MyThread("3rd", res);
        t1.start(); t2.start(); t3.start();
        t1.join(); t2.join(); t3.join();
    }
}
```

**Output (with synchronization):**
```
[1st]
[2nd]
[3rd]
```

## Key Points

| Feature | Description |
|---------|-------------|
| **Monitor Lock** | Every Java object has a lock; `synchronized` acquires it |
| **Mutual Exclusion** | Only one thread can hold the lock at a time |
| **Visibility** | Changes made in a synchronized block are visible to all threads |
| **Deadlock Risk** | If two threads wait for each other's lock, a deadlock occurs |
