// Lab Sheet 2 - Q2
// a) Display number of characters, sentences and words in multithread.txt
// b) Display content with line numbers

import java.io.*;

public class FileStats {
    public static void main(String[] args) throws Exception {
        File file = new File("linus\\multithread.txt"); // change folder name as needed
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        int wordCount = 0;
        int characterCount = 0;
        int sentenceCount = 0;
        int lineCount = 0;

        while ((line = br.readLine()) != null) {
            characterCount += line.length();
            String[] words = line.split("\\s+");
            wordCount += words.length;
            String[] sentences = line.split("[!?.:]+");
            sentenceCount += sentences.length;
            System.out.println(++lineCount + " " + line);
        }

        System.out.println("Total word count = " + wordCount);
        System.out.println("Total number of sentences = " + sentenceCount);
        System.out.println("Total number of characters = " + characterCount);

        br.close();
    }
}
