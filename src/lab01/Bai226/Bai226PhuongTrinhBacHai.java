package lab01.Bai226;

import javax.swing.JOptionPane;

public class Bai226PhuongTrinhBacHai {
	public static void main(String[] args) {
		String a1,b1,c1;
		a1= JOptionPane.showInputDialog(null,"Enter a (different from 0):","Solve equation ax^2+bx+c=0",JOptionPane.QUESTION_MESSAGE);
		b1= JOptionPane.showInputDialog(null,"Enter b:","Solve equation ax^2+bx+c=0",JOptionPane.QUESTION_MESSAGE);
		c1= JOptionPane.showInputDialog(null,"Enter c:","Solve equation ax^2+bx+c=0",JOptionPane.QUESTION_MESSAGE);
		double a = Double.parseDouble(a1);
		double b = Double.parseDouble(b1);
		double c = Double.parseDouble(c1);     
		
		double delta = b*b-4*a*c;
		String x;
        if(delta == 0) {
    		double x12= (-b )/ (2*a);
        	x = "Equation has double root:"+ "\n"
        			+ "x1 = x2 = " + x12 ; 
        }
        else if (delta < 0) {
        	x = "Equation has no root";
        }
        else {
    		double x1= (-b+ Math.sqrt(delta)) / (2*a);
    		double x2= (-b- Math.sqrt(delta)) / (2*a);
        	x = "Equation has two distinct roots: " + "\n"
        			+ "x1 = " + x1 + "\n"
        			+ "x2 = " + x2 ;
        }
		JOptionPane.showMessageDialog(null, x , "Solve equation ax^2+bx+c=0",JOptionPane.QUESTION_MESSAGE) ;
		System.exit(0);
        
	}
}

