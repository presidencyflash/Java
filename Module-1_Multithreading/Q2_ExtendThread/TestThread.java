/**
 * Q2: Create a single thread by extending Thread class.
 */
class MyThread extends Thread {
    public void run() {
        int a = 10;
        int b = 12;
        int result = a + b;
        System.out.println(Thread.currentThread() + " started running..");
        System.out.println("Sum of two numbers is: " + result);
        System.out.println(Thread.currentThread() + " completed..");
    }
}

public class TestThread {
    public static void main(String args[]) {
        System.out.println(Thread.currentThread() + " started");
        MyThread t = new MyThread();
        t.setName("first");
        t.start();
        System.out.println(Thread.currentThread() + " completed");
    }
}
