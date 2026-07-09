/**
 * Q5: Create three threads by setting different priorities to each thread.
 * Valid priority range: Thread.MIN_PRIORITY (1) to Thread.MAX_PRIORITY (10).
 * Setting priority > 10 throws IllegalArgumentException.
 */
class ThreadPrior extends Thread {
    public void run() {
        System.out.println("Inside run method");
    }
}

public class TestThreadPrior {
    public static void main(String[] args) {
        ThreadPrior t1 = new ThreadPrior();
        ThreadPrior t2 = new ThreadPrior();
        ThreadPrior t3 = new ThreadPrior();

        System.out.println("t1 thread priority : " + t1.getPriority());
        System.out.println("t2 thread priority : " + t2.getPriority());
        System.out.println("t3 thread priority : " + t3.getPriority());

        t1.setPriority(2);
        t2.setPriority(5);
        t3.setPriority(8);
        // t3.setPriority(21); // This would throw IllegalArgumentException

        System.out.println("t1 thread priority : " + t1.getPriority());
        System.out.println("t2 thread priority : " + t2.getPriority());
        System.out.println("t3 thread priority : " + t3.getPriority());

        System.out.println("Currently Executing Thread : " + Thread.currentThread().getName());
        System.out.println("Main thread priority : " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(10);
        System.out.println("Main thread priority : " + Thread.currentThread().getPriority());
    }
}
