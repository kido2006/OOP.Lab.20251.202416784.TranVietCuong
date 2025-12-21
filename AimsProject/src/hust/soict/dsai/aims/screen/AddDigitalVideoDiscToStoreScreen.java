package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD");
    }

    @Override
    protected void onAddPressed() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String director = tfDirector.getText().trim();
        int length = readLength();
        float cost = readCost();

        if (title.isEmpty() || category.isEmpty() || director.isEmpty()
                || length <= 0 || cost < 0) {
            JOptionPane.showMessageDialog(this, "Invalid input!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DigitalVideoDisc dvd =
                new DigitalVideoDisc(title, category, director, length, cost);

        try {
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(
                this,
                "Added DVD: " + title
            );
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Duplicate media",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }


        dispose();
    }
}
