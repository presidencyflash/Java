# Q9. List the Drawbacks of Traditional java.io.* and How NIO (Channel & Buffer) Overcomes Them

## Drawbacks of Traditional java.io.*

| Drawback | Description |
|----------|-------------|
| **Blocking I/O** | Threads block while waiting for I/O to complete; cannot do other work |
| **No non-blocking support** | Cannot check if data is available without blocking |
| **Byte-by-byte processing** | Reads one byte/char at a time; inefficient for large files |
| **No direct memory access** | Cannot map files directly into memory |
| **No scatter/gather** | Cannot read from multiple buffers into a single channel or vice versa |
| **Thread-per-connection** | Servers need one thread per client, causing high memory usage |

## Java NIO – New I/O (`java.nio`)

Introduced in Java 1.4, **NIO** (New Input/Output) provides:
- **Channels** — bidirectional data pipes
- **Buffers** — containers holding data
- **Selectors** — monitor multiple channels with a single thread (non-blocking)

## Channel and Buffer Concept

```
   File / Network
        |
   [ Channel ]  <-- bidirectional data pipe
        |
   [ Buffer ]   <-- data is read into / written from here
        |
     Program
```

**Key rule:** Data always goes **Program → Buffer → Channel → Destination** and **Source → Channel → Buffer → Program**.

## Sample Program (FileChannel + ByteBuffer)

```java
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class NIODemo {
    public static void main(String[] args) {
        String data = "Hello NIO World!";

        // WRITE using FileChannel
        try (RandomAccessFile file = new RandomAccessFile("nio_test.txt", "rw")) {
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(data.length());
            for (int i = 0; i < data.length(); i++)
                buffer.put((byte) data.charAt(i));
            buffer.rewind(); // reset position to 0 before writing
            channel.write(buffer);
            System.out.println("Written using NIO.");
        } catch (Exception e) { e.printStackTrace(); }

        // READ using FileChannel
        try (RandomAccessFile file = new RandomAccessFile("nio_test.txt", "r")) {
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = channel.read(buffer);
            System.out.print("Read: ");
            for (int i = 0; i < bytesRead; i++)
                System.out.print((char) buffer.get(i));
        } catch (Exception e) { e.printStackTrace(); }
    }
}
```

## java.io vs java.nio

| Feature | java.io | java.nio |
|---------|---------|----------|
| Mode | Blocking | Non-blocking possible |
| Data unit | Byte/Char stream | Buffers |
| Direction | Unidirectional | Bidirectional |
| Performance | Lower for large files | Higher (direct memory) |
| File mapping | Not supported | `MappedByteBuffer` |
