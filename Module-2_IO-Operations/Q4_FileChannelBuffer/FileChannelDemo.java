import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

/**
 * Q4: Read and write operations using FileChannel and ByteBuffer.
 * Channels are tubes through which data is transferred; Buffers are source/target.
 */
public class FileChannelDemo {
    public static void main(String args[]) {
        String data = "iphone 6 50000";
        write("tablet.store", data);
        read("tablet.store");
    }

    public static void write(String filename, String data) {
        try {
            RandomAccessFile store = new RandomAccessFile(filename, "rw");
            FileChannel channel = store.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(data.length());
            for (int i = 0; i < data.length(); i++) {
                buffer.put((byte) (data.charAt(i)));
            }
            buffer.rewind(); // position set to zero before writing
            channel.write(buffer);
            channel.close();
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void read(String filename) {
        try {
            RandomAccessFile store = new RandomAccessFile(filename, "rw");
            FileChannel channel = store.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int numOfBytesRead = channel.read(buffer);
            System.out.println("number of bytes read : " + numOfBytesRead);
            for (int i = 0; i < numOfBytesRead; i++) {
                char c = (char) buffer.get(i);
                System.out.print(c);
            }
            channel.close();
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
