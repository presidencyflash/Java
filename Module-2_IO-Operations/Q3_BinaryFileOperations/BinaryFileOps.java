// Lab Sheet 2 - Q3
// Operations with Binary files (.dat)
// a) Create folder  b) Create .dat file with header  c) Add student records  d) Read file to console

import java.io.*;
import java.util.Scanner;

public class BinaryFileOps {

    // a) Create folder
    public static void createFolder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter folder name:");
        String foldername = sc.next();
        File f = new File(foldername);
        if (f.exists() && f.isDirectory())
            System.out.println("Folder already exists");
        else if (f.mkdir())
            System.out.println("Folder successfully created");
        else
            System.out.println("Cannot be created");
    }

    // b) Create .dat file and write header
    public static void createFile(String foldername, String filename) throws Exception {
        FileOutputStream output = new FileOutputStream(foldername + "\\" + filename + ".dat");
        String header = "Name\tRegdno\tEssaySubmitted";
        output.write(header.getBytes());
        System.out.println("File created and header written");
        output.close();
    }

    // c) Add student records to the .dat file
    public static void addRecords(String filepath) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileOutputStream output = new FileOutputStream(filepath, true);
        char ch = 'n';
        do {
            System.out.println("Enter: StudentName RegdNo(int) Submitted(y/n)");
            String name = sc.next();
            int regdno = sc.nextInt();
            char submitted = sc.next().charAt(0);
            String newrecord = "\n" + name + "\t" + regdno + "\t\t" + submitted;
            output.write(newrecord.getBytes());
            System.out.println("Enter y for more students, n to stop:");
            ch = sc.next().charAt(0);
        } while (ch != 'n');
        System.out.println("Records written to file");
        output.close();
    }

    // d) Read .dat file to console
    public static void readFile(String filepath) throws Exception {
        FileInputStream fis = new FileInputStream(new File(filepath));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        String folder = "4cse";
        String filename = "4cse_student";
        String filepath = folder + "\\" + filename + ".dat";

        createFolder();
        createFile(folder, filename);
        addRecords(filepath);
        readFile(filepath);
    }
}
