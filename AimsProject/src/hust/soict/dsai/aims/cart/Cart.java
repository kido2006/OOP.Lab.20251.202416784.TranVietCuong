package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
    
    public static final int MAX_NUMBERS_ORDERED = 20;

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException(
                "ERROR: The number of media has reached its limit"
            );
        }
        if (itemsOrdered.contains(media)) {
            throw new IllegalArgumentException("This item is already in your cart!");
        }
        itemsOrdered.add(media);
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Media not found in cart!");
        }
    }

    public void removeMedia(String title) {
        Media m = searchMedia(title);
        if (m != null) {
            removeMedia(m);
        } else {
            System.out.println("Media not found.");
        }
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println(m.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No media with ID " + id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println(m.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No media with title " + title);
    }

    public Media searchMedia(String title) {
        if (title == null) return null;
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public void sortMediaByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortMediaByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void playMedia(String title) {
        Media m = searchMedia(title);
        if (m == null) {
            System.out.println("Media not found.");
            return;
        }
        if (m instanceof hust.soict.dsai.aims.media.Playable) {
            try {
                ((hust.soict.dsai.aims.media.Playable) m).play();
            } catch (hust.soict.dsai.aims.exception.PlayerException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public void empty() {
        itemsOrdered.clear();
        System.out.println("Order created. Cart is now empty!");
    }

    // Total cost
    public float totalCost() {
        float sum = 0;
        for (Media m : itemsOrdered) sum += m.getCost();
        return sum;
    }

    // Print cart
    public void printCart() {
        System.out.println("********************CART********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }

        System.out.println("--------------------------------------------");
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("********************************************");
    }
}
