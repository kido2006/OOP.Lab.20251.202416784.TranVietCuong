package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGrid extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete;
    private JButton btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        // Display text field (NORTH)
        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        tfDisplay.setFont(new Font("SansSerif", Font.PLAIN, 20));

        // Panel button (CENTER)
        JPanel panelButtons = new JPanel(new GridLayout(4, 3, 5, 5));
        addButtons(panelButtons);

        // Layout JFrame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(5, 5));
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setTitle("Number Grid");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();

        // Buttons 1 -> 9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            btnNumbers[i].setFont(new Font("SansSerif", Font.BOLD, 18));
            btnNumbers[i].addActionListener(btnListener);
            panelButtons.add(btnNumbers[i]);
        }

        // DEL button
        btnDelete = new JButton("DEL");
        btnDelete.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnDelete.addActionListener(btnListener);
        panelButtons.add(btnDelete);

        // Button 0
        btnNumbers[0] = new JButton("0");
        btnNumbers[0].setFont(new Font("SansSerif", Font.BOLD, 18));
        btnNumbers[0].addActionListener(btnListener);
        panelButtons.add(btnNumbers[0]);

        // Reset button
        btnReset = new JButton("C");
        btnReset.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnReset.addActionListener(btnListener);
        panelButtons.add(btnReset);
    }

    // Named inner class
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            String currentText = tfDisplay.getText();

            // Digit buttons
            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                tfDisplay.setText(currentText + command);
                return;
            }

            // DEL button
            if (command.equals("DEL")) {
                if (currentText.length() > 0) {
                    tfDisplay.setText(
                        currentText.substring(0, currentText.length() - 1)
                    );
                }
                return;
            }

            // Reset button (C)
            tfDisplay.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberGrid::new);
    }
}
