package hust.soict.dsai.garbage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        File file = new File("test.exe");
        
        long start = System.currentTimeMillis();
        
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fis.read(bytes);
        fis.close();

        String output = "";
        for (int i = 0; i < bytes.length; i++) {
            output += (char) bytes[i];
        }
        
        long end = System.currentTimeMillis();
        System.out.println("Done");
        System.out.println("Processing time: " + (end - start) + " ms");

    }
}
