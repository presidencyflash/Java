import java.io.*;
import java.io.Serializable;

/**
 * Student class implementing Serializable for object persistence.
 */
class Student implements Serializable {
    String name;
    String regdno;
    double cgpa;
}

/**
 * Q5: Serialize a Student object to a .ser file.
 */
public class SerializeDemo {
    public static void main(String[] args) throws Exception {
        Student s = new Student();
        s.name = "sanjay";
        s.regdno = "20213cse0123";
        s.cgpa = 7.5;

        FileOutputStream fileOut = new FileOutputStream("tmp//student.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(s);
        out.close();
        fileOut.close();
        System.out.printf("Serialized data is saved in tmp/student.ser");
    }
}
