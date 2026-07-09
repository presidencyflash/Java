import java.io.*;

/**
 * Q1d: Copy the content of one text file to another.
 * Uses PrintWriter (alternatively BufferedWriter can be used).
 */
public class CopyFile {
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
        System.out.println("1 file copied");
        br.close();
        pw.close();
    }
}
