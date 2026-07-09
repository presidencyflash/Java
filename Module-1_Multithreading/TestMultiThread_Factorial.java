// Lab Sheet 1 - Q4
// Create 3 threads to print factorial of 3 different numbers concurrently
// Demonstrates join() and isAlive()

class MyThread extends Thread {
    String name;
    int number;
    long fact = 1;

    MyThread(int number, String name) {
        super(name); // calling Thread(String name) constructor
        this.number = number;
        this.name = name;
        System.out.println("A New thread: " + name + " is created");
    }

    public void run() {
        try {
            for (int i = 1; i <= number; i++) {
                System.out.println(name + " calculating factorial");
                fact = fact * i;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " thread Interrupted");
        }
        System.out.println(name + " calculated factorial " + fact);
    }
}

public class TestMultiThread_Factorial {
    public static void main(String args[]) {
        MyThread t1 = new MyThread(5, "one");
        MyThread t2 = new MyThread(4, "two");
        MyThread t3 = new MyThread(3, "three");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("1st Alive : " + t1.isAlive());
        System.out.println("2nd Alive : " + t2.isAlive());
        System.out.println("3rd Alive : " + t3.isAlive());

        try {
            t1.join();
            t2.join();
            t3.join();

            System.out.println("1st Alive : " + t1.isAlive());
            System.out.println("2nd Alive : " + t2.isAlive());
            System.out.println("3rd Alive : " + t3.isAlive());
        } catch (InterruptedException e) {
            System.out.println("Interruption occurs in Main Thread");
        }

        System.out.println("We are exiting from Main Thread");
    }
}
