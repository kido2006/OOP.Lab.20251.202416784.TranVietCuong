package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingAccumulator extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;   // Accumulated sum, init to 0

    // Constructor to setup the GUI components and event handlers
    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an Integer: "));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        cp.add(new JLabel("The Accumulated Sum is: "));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close
 
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

    private class TFInputListener implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    	    try {
    	        int number = Integer.parseInt(tfInput.getText().trim());
    	        sum += number;
    	        tfOutput.setText(String.valueOf(sum));
    	    } catch (NumberFormatException ex) {
    	        JOptionPane.showMessageDialog(
    	            SwingAccumulator.this,
    	            "Please enter a valid integer!",
    	            "Input Error",
    	            JOptionPane.ERROR_MESSAGE
    	        );
    	    } finally {
    	        tfInput.setText("");
    	    }
    	}
    }
}
