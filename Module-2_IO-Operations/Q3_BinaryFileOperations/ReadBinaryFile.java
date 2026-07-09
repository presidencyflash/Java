import java.io.*;

/**
 * Q3d: Read a binary .dat file and display contents to console.
 */
public class ReadBinaryFile {
    public static void main(String[] args) throws Exception {
        File file = new File("linus\\4cse_student.dat");
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
