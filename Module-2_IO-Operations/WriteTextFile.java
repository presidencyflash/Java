// Lab Sheet 2 - Q1b
// Create a file and write an essay to it using FileWriter
// File name: multithread.txt inside a folder entered at runtime

import java.io.FileWriter;
import java.util.Scanner;

public class WriteTextFile {
    public static void main(String args[]) throws Exception {
        String essay = "Multithreading is a Java feature that allows concurrent execution\n"
                + "of two or more parts of a program for maximum utilization of CPU.\n"
                + "Each part of such a program is called a thread.\n"
                + "Threads are light-weight processes within a process.\n";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter folder name:");
        String foldername = sc.next();

        FileWriter output = new FileWriter(foldername + "\\multithread.txt");
        System.out.println("File created");
        output.write(essay);
        System.out.println("File written successfully");
        output.close();
    }
}
