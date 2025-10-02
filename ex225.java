package lab01;
import javax.swing.JOptionPane; 

public class ex225 {

	public static void main(String[] args) {
		String strNum1;
		strNum1 = JOptionPane.showInputDialog("Nhap so thu nhat:");
		double num1 = Double.parseDouble(strNum1);
		
		String strNum2;
		strNum2 = JOptionPane.showInputDialog("Nhap so thu hai:");
		double num2 = Double.parseDouble(strNum2);	
		
        double sum = num1+num2;
        double difference = num1-num2;
        double product = num1*num2;
        String quotient;
        if(num2 == 0) {
        	quotient = "Khong the chia cho 0";
        }
        else {
        	quotient = String.valueOf(num1/num2);
        }
        
        String mes = "So thu nhat: " + num1 +"\n" 
        			+"So thu hai: " + num2 + "\n"
        			+"Tong: " + sum + "\n"
        			+"Hieu: " + difference + "\n"
        			+"Tich: " + product + "\n"
        			+"Thuong: " + quotient ;
		JOptionPane.showMessageDialog(null, mes);
		System.exit(0);
	}

}
