import java.io.*;
import java.util.Scanner;

/**
 * Q1a: Create a folder with a student name passed at runtime.
 */
public class CreateFolder {
    public static void main(String arr[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter folder name");
        String foldername = sc.next();
        File f = new File(foldername);
        if (f.exists() && f.isDirectory())
            System.out.println("already exist");
        else if (f.mkdir() == true)
            System.out.println("successfully created");
        else
            System.out.println("cannot be created");
    }
}
