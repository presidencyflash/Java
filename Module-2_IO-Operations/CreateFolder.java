// Lab Sheet 2 - Q1a
// Create a folder with name entered at runtime using Scanner

import java.io.*;
import java.util.Scanner;

public class CreateFolder {
    public static void main(String arr[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter folder name");
        String foldername = sc.next();

        File f = new File(foldername);

        if (f.exists() && f.isDirectory())
            System.out.println("Folder already exists");
        else if (f.mkdir() == true)
            System.out.println("Folder successfully created");
        else
            System.out.println("Cannot be created");
    }
}
