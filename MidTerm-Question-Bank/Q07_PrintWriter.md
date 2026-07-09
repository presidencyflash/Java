# Q7. Explain PrintWriter Class with Simple Program

## What is PrintWriter?

`java.io.PrintWriter` is a character-output stream that provides convenient methods to **write formatted text** to a file or output stream. It is preferred over `FileWriter` when you want to use `print()`, `println()`, and `printf()` methods.

## Key Features
- Writes **character data** (text) to a file
- Supports `print()`, `println()`, `printf()`, `format()`
- Can auto-flush when `println()` is called (if `autoFlush = true`)
- Does **not throw checked exceptions** from print methods (unlike `FileWriter`)

## Constructor

```java
PrintWriter pw = new PrintWriter(new FileWriter("file.txt"), false); // autoFlush = false
PrintWriter pw = new PrintWriter("file.txt");                        // direct file path
```

## Important Methods

| Method | Description |
|--------|-------------|
| `print(value)` | Writes value without newline |
| `println(value)` | Writes value with newline |
| `printf(format, args)` | Formatted output (like C printf) |
| `flush()` | Flushes the stream |
| `close()` | Closes the stream |

## Sample Program

```java
import java.io.*;

public class PrintWriterDemo {
    public static void main(String[] args) throws Exception {

        // Writing to a file using PrintWriter
        PrintWriter pw = new PrintWriter(new FileWriter("students.txt"), false);

        pw.println("Name\t\tRollNo\tCGPA");
        pw.println("Alice\t\t101\t8.5");
        pw.println("Bob\t\t102\t7.9");
        pw.printf("%-10s\t%d\t%.1f%n", "Charlie", 103, 9.1);

        System.out.println("Data written to students.txt");
        pw.flush();
        pw.close();

        // Reading back the file
        BufferedReader br = new BufferedReader(new FileReader("students.txt"));
        String line;
        System.out.println("\nFile contents:");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
```

**Output:**
```
Data written to students.txt

File contents:
Name        RollNo  CGPA
Alice       101     8.5
Bob         102     7.9
Charlie     103     9.1
```
