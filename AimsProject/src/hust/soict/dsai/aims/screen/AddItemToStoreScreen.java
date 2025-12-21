package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {

    protected Store store;
    protected Cart cart;

    protected JTextField tfTitle = new JTextField(20);
    protected JTextField tfCategory = new JTextField(20);
    protected JTextField tfDirector = new JTextField(20);
    protected JTextField tfLength = new JTextField(20);
    protected JTextField tfCost = new JTextField(20);

    public AddItemToStoreScreen(Store store, Cart cart, String screenTitle) {
        this.store = store;
        this.cart = cart;

        setTitle(screenTitle);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        form.add(new JLabel("Title:"));
        form.add(tfTitle);

        form.add(new JLabel("Category:"));
        form.add(tfCategory);

        form.add(new JLabel("Director:"));
        form.add(tfDirector);

        form.add(new JLabel("Length:"));
        form.add(tfLength);

        form.add(new JLabel("Cost:"));
        form.add(tfCost);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAdd = new JButton("Add");
        JButton btnCancel = new JButton("Cancel");
        bottom.add(btnCancel);
        bottom.add(btnAdd);

        btnCancel.addActionListener(e -> dispose());
        btnAdd.addActionListener(e -> onAddPressed());

        cp.add(form, BorderLayout.CENTER);
        cp.add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    protected float readCost() {
        try {
            return Float.parseFloat(tfCost.getText().trim());
        } catch (Exception e) {
            return -1f;
        }
    }

    protected int readLength() {
        try {
            return Integer.parseInt(tfLength.getText().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    protected abstract void onAddPressed();
}
