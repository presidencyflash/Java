# Q1. What is Multithreading? Explain Life Cycle of a Thread with a neat diagram.

## What is Multithreading?

Multithreading is the ability of a CPU (or a single core) to provide multiple threads of execution concurrently, supported by the operating system. In Java, multithreading allows **multiple threads to run simultaneously** within a single program, sharing the same process memory but executing independently.

**Key benefits:**
- Better CPU utilization
- Faster program execution for parallel tasks
- Responsive user interfaces (UI thread stays active)
- Efficient resource sharing

## Thread Life Cycle

A Java thread goes through **5 states** during its lifetime:

```
                          +------------------+
                          |    NEW           |  <-- Thread object created (before start())
                          +--------+---------+
                                   |
                                start()
                                   |
                                   v
                          +------------------+
          +-------------> |   RUNNABLE       |  <-- Ready to run / currently running
          |               +--------+---------+
          |                        |
          |              sleep() / wait() / IO
          |                        |
          |                        v
          |               +------------------+
          +-------------- |    BLOCKED /     |  <-- Waiting for lock, sleep, or I/O
   notify()/interrupt()   |    WAITING /     |
                          |    TIMED_WAITING |
                          +------------------+
                                   |
                           run() finishes
                                   |
                                   v
                          +------------------+
                          |   TERMINATED     |  <-- Thread has completed execution
                          +------------------+
```

## States Explained

| State | Description |
|-------|-------------|
| **NEW** | Thread object is created but `start()` has not been called yet |
| **RUNNABLE** | Thread is eligible to run; may be running or waiting for CPU time |
| **BLOCKED** | Thread is waiting to acquire a monitor lock (e.g., waiting to enter `synchronized` block) |
| **WAITING** | Thread is waiting indefinitely for another thread to perform an action (`wait()`, `join()`) |
| **TIMED_WAITING** | Thread waits for a specified time (`sleep(ms)`, `wait(ms)`, `join(ms)`) |
| **TERMINATED** | Thread has finished execution (run() method returned or exception thrown) |

## Example

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is in RUNNABLE state");
        try {
            Thread.sleep(1000); // moves to TIMED_WAITING
        } catch (InterruptedException e) { }
        System.out.println("Thread resuming after sleep");
    }
}

public class LifeCycleDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();    // NEW
        System.out.println("State: " + t.getState()); // NEW
        t.start();                      // RUNNABLE
        System.out.println("State: " + t.getState()); // RUNNABLE
        t.join();                       // main waits
        System.out.println("State: " + t.getState()); // TERMINATED
    }
}
```
