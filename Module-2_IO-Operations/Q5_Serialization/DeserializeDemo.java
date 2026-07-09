import java.io.*;

/**
 * Q5: Deserialize a Student object from a .ser file.
 */
public class DeserializeDemo {
    public static void main(String[] args) throws Exception {
        Student s = null;
        FileInputStream fileIn = new FileInputStream("tmp//student.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        s = (Student) in.readObject();
        in.close();
        fileIn.close();
        System.out.println("Deserialized Student...");
        System.out.println("Name: " + s.name);
        System.out.println("Regd no: " + s.regdno);
        System.out.println("CGPA: " + s.cgpa);
    }
}
