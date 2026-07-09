# Q10. Explain Serialization and Deserialization with Simple Program

## What is Serialization?

**Serialization** is the process of converting a Java **object into a byte stream** so it can be:
- Saved to a file (`.ser`)
- Sent over a network
- Stored in a database

**Deserialization** is the reverse — converting the byte stream back into a Java object.

## Requirements

- The class must implement `java.io.Serializable` (marker interface — no methods to implement)
- Fields marked `transient` are **NOT serialized**
- All fields must also be serializable (or transient)

## Classes Used

| Class | Purpose |
|-------|---------|
| `ObjectOutputStream` | Serializes the object to a stream |
| `ObjectInputStream` | Deserializes the object from a stream |
| `FileOutputStream` | Output stream to a file |
| `FileInputStream` | Input stream from a file |

## Program

```java
import java.io.*;

// Must implement Serializable
class Student implements Serializable {
    String name;
    String regdno;
    double cgpa;
    transient String password; // will NOT be serialized
}

// --- Serialization ---
public class SerializeDemo {
    public static void main(String[] args) throws Exception {
        Student s = new Student();
        s.name = "sanjay";
        s.regdno = "20213cse0123";
        s.cgpa = 7.5;
        s.password = "secret123"; // this will be lost after deserialization

        FileOutputStream fileOut = new FileOutputStream("student.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(s);
        out.close();
        fileOut.close();
        System.out.println("Object serialized to student.ser");
    }
}

// --- Deserialization ---
public class DeserializeDemo {
    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("student.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Student s = (Student) in.readObject();
        in.close();
        fileIn.close();

        System.out.println("Deserialized Student:");
        System.out.println("Name: " + s.name);
        System.out.println("Regd No: " + s.regdno);
        System.out.println("CGPA: " + s.cgpa);
        System.out.println("Password: " + s.password); // null (transient)
    }
}
```

**Output (Deserialization):**
```
Deserialized Student:
Name: sanjay
Regd No: 20213cse0123
CGPA: 7.5
Password: null
```

## Use Cases
- Saving game state
- HTTP session objects in web apps
- Distributed Java (RMI)
- Caching objects to disk
