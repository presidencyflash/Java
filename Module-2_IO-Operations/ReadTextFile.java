// Lab Sheet 2 - Q1c
// Read the content of multithread.txt to the output console using BufferedReader

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadTextFile {
    public static void main(String args[]) throws Exception {
        File fileob = new File("linus\\multithread.txt"); // change folder name as needed
        FileReader fr = new FileReader(fileob);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
