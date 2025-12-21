package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;

public class StoreScreenController {

    private Store store;
    private Cart cart;

    @FXML
    private FlowPane flowPane;

    public StoreScreenController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        for (Media media : store.getItemsInStore()) {
            MediaStore mediaStore =
                new MediaStore(media, cart);
            flowPane.getChildren().add(mediaStore);
        }
    }
    @FXML
    void handleAddBook() {
        AddBookToStoreScreen screen =
                new AddBookToStoreScreen(store, cart);

        screen.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                javafx.application.Platform.runLater(() -> refreshStore());
            }
        });
    }


    @FXML
    void handleAddCD() {
        AddCompactDiscToStoreScreen screen =
                new AddCompactDiscToStoreScreen(store, cart);

        screen.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                javafx.application.Platform.runLater(() -> refreshStore());
            }
        });
    }


    @FXML
    void handleAddDVD() {
        AddDigitalVideoDiscToStoreScreen screen =
                new AddDigitalVideoDiscToStoreScreen(store, cart);

        screen.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                javafx.application.Platform.runLater(() -> refreshStore());
            }
        });
    }


    @FXML
    void handleViewCart() {
        new CartScreen(store, cart);
    }
    public void refreshStore() {
        flowPane.getChildren().clear();
        for (Media media : store.getItemsInStore()) {
            MediaStore mediaStore = new MediaStore(media, cart);
            flowPane.getChildren().add(mediaStore);
        }
    }
}
