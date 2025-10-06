package lab01.Bai226;

import javax.swing.JOptionPane; 

public class Bai226PhuongTrinhBacNhat {
	public static void main(String[] args) {
		String a,b;
		a= JOptionPane.showInputDialog(null,"Enter a:","Solve equation ax+b=0",JOptionPane.QUESTION_MESSAGE);
		b= JOptionPane.showInputDialog(null,"Enter b:","Solve equation ax+b=0",JOptionPane.QUESTION_MESSAGE);	
		
		double num1 = Double.parseDouble(a);
		double num2 = Double.parseDouble(b);
		
		String x;
        if(num1 == 0 && num2 != 0 ) {
        	x = "Equation has no solution";
        }
        else if (num1 == 0 && num2 == 0 ) {
        	x = "Equation has infinite solutions";
        }
        else {
        	x = "Answer for ax+b=0 is: x=" + String.valueOf(-num2/num1);
        }
		JOptionPane.showMessageDialog(null, x);
		System.exit(0);
        
	}

}

