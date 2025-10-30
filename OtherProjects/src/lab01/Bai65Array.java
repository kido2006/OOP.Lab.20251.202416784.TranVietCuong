package lab01;

import java.util.Scanner;
import java.util.Arrays;
public class Bai65Array {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int sum = 0;
		
		
		System.out.print("Enter numbers (separated by spaces): ");
		String input = keyboard.nextLine().trim();
		
		String[] parts = input.split("\\s+");
		int[] myarray1 = new int[parts.length];
		
        for (int i = 0; i < parts.length; i++) {
            myarray1[i] = Integer.parseInt(parts[i]);
            sum += myarray1[i];
        }
        
        double avg = (double) sum/parts.length ;
        
        System.out.println("Original array: " + Arrays.toString(myarray1));
        
        Arrays.sort(myarray1);
        System.out.println("Sorted array: " + Arrays.toString(myarray1));
        
        System.out.println("Sum of the array is " + sum);
        System.out.println("Average value of the array is " + avg);
        
		keyboard.close();

	}

}
