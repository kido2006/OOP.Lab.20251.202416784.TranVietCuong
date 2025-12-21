package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MediaStore extends VBox {

    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        setPrefWidth(260);
        setMaxWidth(260);

        setSpacing(10);
        setAlignment(Pos.CENTER);
        getStyleClass().add("media-card");

        Label title = new Label(media.getTitle());
        title.getStyleClass().add("media-title");

        Label cost = new Label(media.getCost() + " $");
        cost.getStyleClass().add("media-price");

        Button btnAdd = new Button("Add to cart");
        btnAdd.getStyleClass().add("btn-add");

        btnAdd.setOnAction(e -> {
            try {
                cart.addMedia(media);
                showInfo("Added to cart: " + media.getTitle());
            } catch (LimitExceededException ex) {
                showError(ex.getMessage());
            } catch (IllegalArgumentException ex) {
                showError(ex.getMessage());
            }
        });

        HBox buttons = new HBox(10, btnAdd);
        buttons.setAlignment(Pos.CENTER);

        if (media instanceof Playable) {
            Button btnPlay = new Button("Play");
            btnPlay.getStyleClass().add("btn-play");

            btnPlay.setOnAction(e -> {
                try {
                    ((Playable) media).play();
                    showInfo("Playing: " + media.getTitle());
                } catch (PlayerException ex) {
                    showError(ex.getMessage());
                }
            });

            buttons.getChildren().add(btnPlay);
        }

        getChildren().addAll(title, cost, buttons);
    }

    private void showInfo(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
