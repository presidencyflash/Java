# Q6. Explain File Class with Sample Program

## What is the File Class?

`java.io.File` represents a **file or directory path** in the file system. It does **not** read/write file content — it only provides metadata and file management operations.

## Commonly Used Methods

| Method | Description |
|--------|-------------|
| `exists()` | Returns true if the file/directory exists |
| `isFile()` | Returns true if it’s a file |
| `isDirectory()` | Returns true if it’s a directory |
| `mkdir()` | Creates the directory |
| `mkdirs()` | Creates directory including all parent directories |
| `createNewFile()` | Creates a new empty file |
| `delete()` | Deletes the file or directory |
| `getName()` | Returns file name |
| `getPath()` | Returns path string |
| `length()` | Returns file size in bytes |
| `listFiles()` | Returns array of files in a directory |
| `renameTo(File)` | Renames the file |

## Sample Program

```java
import java.io.*;
import java.util.Scanner;

public class FileClassDemo {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter folder name: ");
        String folderName = sc.next();

        // Create directory
        File dir = new File(folderName);
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Directory already exists.");
        } else if (dir.mkdir()) {
            System.out.println("Directory created: " + dir.getPath());
        } else {
            System.out.println("Failed to create directory.");
        }

        // Create a file inside the directory
        File file = new File(folderName + File.separator + "notes.txt");
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("File size: " + file.length() + " bytes");
        }

        // List files in directory
        System.out.println("\nFiles in directory:");
        for (File f : dir.listFiles()) {
            System.out.println("  " + f.getName());
        }
    }
}
```

**Sample Output:**
```
Enter folder name: myFolder
Directory created: myFolder
File created: notes.txt
Absolute path: C:\myFolder\notes.txt
File size: 0 bytes

Files in directory:
  notes.txt
```
