// Lab Sheet 2 - Q1d
// Copy content of multithread.txt to multithread_copy.txt using PrintWriter

import java.io.*;

public class CopyTextFile {
    public static void main(String args[]) throws Exception {
        File source = new File("linus\\multithread.txt");
        File target = new File("linus\\multithread_copy.txt");

        FileReader fr = new FileReader(source);
        FileWriter fw = new FileWriter(target);
        BufferedReader br = new BufferedReader(fr);
        PrintWriter pw = new PrintWriter(fw, false);

        String line;
        while ((line = br.readLine()) != null) {
            pw.write(line);
            pw.println();
        }

        System.out.println("1 file copied successfully");
        br.close();
        pw.close();
    }
}
