# Q8. What is a Stream? Explain Different Types of Streams in Java

## What is a Stream?

In Java I/O, a **stream** is a sequence of data flowing between a **source** (input) and a **destination** (output). It is an abstraction for reading from or writing to any I/O source (files, memory, network, keyboard).

> **Note:** This is Java I/O Streams (`java.io`), not Java 8 Streams API (`java.util.stream`).

## Classification of Streams

### 1. Based on Data Type

```
Streams
├── Byte Streams (8-bit binary data)
│   ├── InputStream  (abstract base)
│   │   ├── FileInputStream
│   │   ├── BufferedInputStream
│   │   └── ObjectInputStream
│   └── OutputStream (abstract base)
│       ├── FileOutputStream
│       ├── BufferedOutputStream
│       └── ObjectOutputStream
└── Character Streams (16-bit Unicode text)
    ├── Reader (abstract base)
    │   ├── FileReader
    │   ├── BufferedReader
    │   └── InputStreamReader
    └── Writer (abstract base)
        ├── FileWriter
        ├── BufferedWriter
        ├── PrintWriter
        └── OutputStreamWriter
```

### 2. Based on Direction

| Type | Direction | Base Classes |
|------|-----------|-------------|
| **Input Stream** | Source → Program | `InputStream`, `Reader` |
| **Output Stream** | Program → Destination | `OutputStream`, `Writer` |

### 3. Byte Stream vs Character Stream

| Feature | Byte Stream | Character Stream |
|---------|-------------|------------------|
| Data unit | 8-bit byte | 16-bit Unicode char |
| Use case | Binary files, images | Text files |
| Base classes | `InputStream`/`OutputStream` | `Reader`/`Writer` |
| Example | `FileInputStream` | `FileReader` |

## Quick Example

```java
import java.io.*;

public class StreamDemo {
    public static void main(String[] args) throws Exception {
        // Character Stream - write
        FileWriter fw = new FileWriter("test.txt");
        fw.write("Hello, Java Streams!");
        fw.close();

        // Character Stream - read
        FileReader fr = new FileReader("test.txt");
        BufferedReader br = new BufferedReader(fr);
        System.out.println(br.readLine()); // Hello, Java Streams!
        br.close();

        // Byte Stream - read
        FileInputStream fis = new FileInputStream("test.txt");
        int b;
        while ((b = fis.read()) != -1) {
            System.out.print((char) b);
        }
        fis.close();
    }
}
```
