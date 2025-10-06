package lab01.Bai226;

import javax.swing.JOptionPane;

public class Bai226HePhuongTrinhBacNhat {
	public static void main(String[] args) {
        String input1 = JOptionPane.showInputDialog(
                null,
                "Enter a1, b1, c1 (separated by space):",
                "Solve system a1x + b1y = c1, a2x + b2y = c2",
                JOptionPane.QUESTION_MESSAGE
        );

        String input2 = JOptionPane.showInputDialog(
                null,
                "Enter a2, b2, c2 (separated by space):",
                "Solve system a1x + b1y = c1, a2x + b2y = c2",
                JOptionPane.QUESTION_MESSAGE
        );     

        String[] line1 = input1.trim().split("\\s+");
        String[] line2 = input2.trim().split("\\s+");    

        double a1 = Double.parseDouble(line1[0]);
        double b1 = Double.parseDouble(line1[1]);
        double c1 = Double.parseDouble(line1[2]);
        double a2 = Double.parseDouble(line2[0]);
        double b2 = Double.parseDouble(line2[1]);
        double c2 = Double.parseDouble(line2[2]);

        double D  = a1*b2 - a2*b1;
        double Dx = c1*b2 - c2*b1;
        double Dy = a1*c2 - a2*c1;

        String mes;
        if (D == 0) {
            if (Dx == 0 && Dy == 0)
                mes = "The system has infinitely many solutions.";
            else
                mes = "The system has no solution.";
        } else {
            double x = Dx / D;
            double y = Dy / D;
            mes = "The system has unique solution:" +"\n" 
        			+"x = " + x + "\n"
        			+"y = " + y + "\n";
        }

        JOptionPane.showMessageDialog(null, mes);
        System.exit(0);
        
	}
}
