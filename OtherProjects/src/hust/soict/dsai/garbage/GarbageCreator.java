package hust.soict.dsai.garbage;

public class GarbageCreator {
    public static void main(String[] args) {
        String base = "abc123xyz";

        byte[] inputBytes = base.getBytes();

        long startTime = System.currentTimeMillis();

        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;  
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }
}