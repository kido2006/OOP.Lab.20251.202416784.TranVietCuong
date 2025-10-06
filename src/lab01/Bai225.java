package lab01;

import javax.swing.JOptionPane;

public class Bai225 {
	public static void main(String[] args) {
		String num1;
		num1 = JOptionPane.showInputDialog(null,"Enter first number:","Calculate",JOptionPane.QUESTION_MESSAGE);
		double a = Double.parseDouble(num1);
		
		String num2;
		num2 = JOptionPane.showInputDialog(null,"Enter second number:","Calculate",JOptionPane.QUESTION_MESSAGE);
		double b = Double.parseDouble(num2);	
		
        double sum = a+b;
        double difference = a-b;
        double product = a*b;
        String quotient;
        if(b == 0) {
        	quotient = "Can not devided by 0";
        }
        else {
        	quotient = String.valueOf(a/b);
        }
        
        String mes = "First number: " + a +"\n" 
        			+"Second number: " + b + "\n"
        			+"Sum: " + sum + "\n"
        			+"Difference: " + difference + "\n"
        			+"Product: " + product + "\n"
        			+"Quotient : " + quotient ;
		JOptionPane.showMessageDialog(null, mes);
		System.exit(0);
	}

}
