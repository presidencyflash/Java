import java.io.FileWriter;
import java.util.Scanner;

/**
 * Q1b: Create and write an essay to a text file.
 */
public class WriteFile {
    public static void main(String args[]) throws Exception {
        String essays = "This is the data in the output file\nThis is the data in the output file\nThis is the data in the output file\n";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name and folder name");
        String filename = sc.next();
        String foldername = sc.next();
        FileWriter output = new FileWriter(foldername + "\\" + filename + ".txt");
        System.out.println("file created");
        output.write(essays);
        System.out.println("file written");
        output.close();
    }
}
