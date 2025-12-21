package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book");

        tfDirector.setEnabled(false);
        tfLength.setEnabled(false);
    }

    @Override
    protected void onAddPressed() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        float cost = readCost();

        if (title.isEmpty() || category.isEmpty() || cost < 0) {
            JOptionPane.showMessageDialog(this, "Invalid input!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Book book = new Book(title, category, cost);
        try {
            store.addMedia(book);
            JOptionPane.showMessageDialog(
                this,
                "Added Book: " + title
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
