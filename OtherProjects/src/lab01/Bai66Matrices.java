package lab01;

import java.util.Scanner;
import java.util.Arrays;
public class Bai66Matrices {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
        System.out.print("Enter number of rows: ");
        int rows = keyboard.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = keyboard.nextInt();
        keyboard.nextLine();
        
        int[][] matrixA = new int[rows][cols];
        int[][] matrixB = new int[rows][cols];
        int[][] result = new int[rows][cols];
        
        System.out.println("Enter Matrix A: ");
        for (int i = 0; i < rows; i++) {
            String[] parts = keyboard.nextLine().trim().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrixA[i][j] = Integer.parseInt(parts[j]);
            }
        }
        
        System.out.println("Enter Matrix B: ");
        for (int i = 0; i < rows; i++) {
            String[] parts = keyboard.nextLine().trim().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrixB[i][j] = Integer.parseInt(parts[j]);
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        
        System.out.println("Sum of matrix A and matrix B is: ");
        printMatrix(result);
        

        
        keyboard.close();

	}
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

}
