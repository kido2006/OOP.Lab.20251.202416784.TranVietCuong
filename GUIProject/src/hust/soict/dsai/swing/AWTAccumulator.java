package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;   // Accumulated sum, init to 0

    // Constructor to setup the GUI components and event handlers
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));

        add(new Label("Enter an Integer: "));

        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        add(new Label("The Accumulated Sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);
        
        setTitle("AWT Accumulator");
        setSize(350, 120);
        // x for close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }

    
    private class TFInputListener implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    	    try {
    	        int number = Integer.parseInt(tfInput.getText().trim());
    	        sum += number;
    	        tfOutput.setText(String.valueOf(sum));
    	    } catch (NumberFormatException ex) {
    	        tfOutput.setText("Please enter a valid integer!");
    	    } finally {
    	        tfInput.setText("");
    	    }
    	}
    }
}
