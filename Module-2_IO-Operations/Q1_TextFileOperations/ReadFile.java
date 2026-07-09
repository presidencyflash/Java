import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Q1c: Read the content of a text file to output console.
 */
public class ReadFile {
    public static void main(String args[]) throws Exception {
        File fileob = new File("linus\\multithread.txt");
        FileReader fr = new FileReader(fileob);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
