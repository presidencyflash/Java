import java.io.*;
import java.util.Scanner;

/**
 * Q3b & Q3c: Create a binary .dat file and write student records to it.
 */
public class WriteBinaryFile {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileOutputStream output = new FileOutputStream("4cse\\4cse_student.dat", true);
        String record = new String();
        String name;
        int regdno;
        char submitted, ch = 'n';

        // Write header first
        String header = "Name\tRegdno\tEssaysubmitted";
        output.write(header.getBytes());

        do {
            System.out.println("Student Name, regdno in integer, submitted or not (y/n)");
            name = sc.next();
            regdno = sc.nextInt();
            submitted = sc.next().charAt(0);
            String newrecord = record.concat("\n").concat(name).concat("\t")
                    .concat(String.valueOf(regdno)).concat("\t\t")
                    .concat(String.valueOf(submitted));
            byte[] arrheader = newrecord.getBytes();
            output.write(arrheader);
            System.out.println("enter y for more students and n to stop");
            ch = sc.next().charAt(0);
        } while (ch != 'n');

        System.out.println("file written");
        output.close();
    }
}
