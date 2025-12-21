package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.store.Store;


public class CartScreen extends JFrame {

    private Store store;
    private Cart cart;

    public CartScreen(Store store, Cart cart) {
        super();
        this.store = store;
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml")
                );
                loader.setController(new CartScreenController(store, cart));

                Parent root = loader.load();         
                Scene scene = new Scene(root);         

                scene.getStylesheets().add(
                	    getClass().getResource("/css/aims.css").toExternalForm()
                );

                fxPanel.setScene(scene);     
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}


