package hust.soict.dsai.aims.screen;

import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	
	private Store store;
    private Cart cart;
    private FilteredList<Media> filteredMedia;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;

    @FXML private Button btnPlay;
    @FXML private Button btnRemove;

    @FXML private Label costLabel;

    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    public CartScreenController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {

        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredMedia = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredMedia);

        cart.getItemsOrdered().addListener(
                (javafx.collections.ListChangeListener<Media>) c -> updateTotalCost()
            );
        updateTotalCost();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> obs,
                                        Media oldVal, Media newVal) {
                        updateButtonBar(newVal);
                    }
                });

        tfFilter.textProperty().addListener((obs, oldText, newText) -> {
            showFilteredMedia(newText);
        });
    }
    
    @FXML
    void handleViewStore() {
    	SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));

    }

    @FXML
    void btnRemovePressed() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected != null) {
            cart.removeMedia(selected);
            updateTotalCost();
        }
    }

    @FXML
    void btnPlayPressed() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected instanceof Playable) {
            try {
                ((Playable) selected).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void placeOrderPressed() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order");
        alert.setHeaderText(null);
        alert.setContentText("Order successfully");
        alert.showAndWait();

        cart.empty();
        updateTotalCost();
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
            return;
        }
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    private void updateTotalCost() {
        costLabel.setText(cart.totalCost() + " $");
    }

    private void showFilteredMedia(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            filteredMedia.setPredicate(p -> true);
            return;
        }

        if (radioBtnFilterId.isSelected()) {
            filteredMedia.setPredicate(media ->
                    String.valueOf(media.getId()).equals(keyword)
            );
        } else if (radioBtnFilterTitle.isSelected()) {
            filteredMedia.setPredicate(media ->
                    media.getTitle().toLowerCase().contains(keyword.toLowerCase())
            );
        }
    }
}
