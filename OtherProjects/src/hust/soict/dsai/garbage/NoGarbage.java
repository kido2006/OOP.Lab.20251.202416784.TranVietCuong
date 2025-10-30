package hust.soict.dsai.garbage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class NoGarbage {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
        File file = new File("test.exe");
        
        long startTime = System.currentTimeMillis();
        
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fis.read(bytes);
        fis.close();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sb.append((char) bytes[i]);
        }
        long endTime = System.currentTimeMillis();

        String output = sb.toString();
        System.out.println("Done (no garbage)");
        System.out.println("Processing time: " + (endTime - startTime) + " ms");
	}

}
