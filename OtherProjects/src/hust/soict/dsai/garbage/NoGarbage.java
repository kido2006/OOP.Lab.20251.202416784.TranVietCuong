package hust.soict.dsai.garbage;

public class NoGarbage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String base = "abc123xyz";
        byte[] inputBytes = base.getBytes();

        long startTime = System.currentTimeMillis();

        StringBuilder output = new StringBuilder();
        for (byte b : inputBytes) {
            output.append((char) b);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time using StringBuilder: " + (endTime - startTime) + " ms");
	}

}
