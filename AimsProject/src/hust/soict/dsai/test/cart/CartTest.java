package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {

        Cart cart = new Cart();

        // Add some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        // Add a duplicate (should be rejected if .contains works)
        DigitalVideoDisc dvd1Dup = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1Dup);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        // Print cart content
        cart.printCart();

        // Filter: search by ID
        System.out.println("\nSearch by ID (1)");
        cart.searchById(1);

        // Filter: search by title
        System.out.println("\nSearch by Title (\"a\")");
        cart.searchByTitle("a");

        // Sorting tests
        System.out.println("\nSort by Title");
        cart.sortMediaByTitle();
        cart.printCart();

        System.out.println("\nSort by Cost");
        cart.sortMediaByCost();
        cart.printCart();

        // Play a DVD
        System.out.println("\nPlay Media (Lion King)");
        cart.playMedia("The Lion King");

        // Remove media test
        System.out.println("\nRemove Media (Star War)");
        cart.removeMedia("Star War");
        cart.printCart();

        // Place order test
        System.out.println("\nPlace Order");
        cart.empty();
        cart.printCart();
    }
}
