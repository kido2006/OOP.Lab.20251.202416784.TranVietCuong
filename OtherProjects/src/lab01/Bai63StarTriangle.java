package lab01;

import java.util.Scanner;
public class Bai63StarTriangle {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		for(int i = 0 ; i < n ; i++) {
			
			for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
			
			for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
			
			System.out.println();
		}
		
		keyboard.close();

	}

}
