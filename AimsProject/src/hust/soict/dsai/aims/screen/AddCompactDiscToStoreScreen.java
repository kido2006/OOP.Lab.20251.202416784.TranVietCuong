package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD");
    }

    @Override
    protected void onAddPressed() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String artist = tfDirector.getText().trim();
        float cost = readCost();

        if (title.isEmpty() || category.isEmpty() || artist.isEmpty() || cost < 0) {
            JOptionPane.showMessageDialog(this, "Invalid input!", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CompactDisc cd = new CompactDisc(
                title,
                category,
                "Unknown",   // director
                artist,
                cost
        );

        try {
            store.addMedia(cd);
            JOptionPane.showMessageDialog(
                this,
                "Added CD: " + title
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
