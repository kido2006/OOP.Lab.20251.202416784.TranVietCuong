package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;

public class AimsGUI {

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        store.addMedia(new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f
        ));

        store.addMedia(new DigitalVideoDisc(
                "Inception",
                "Sci-Fi",
                "Christopher Nolan",
                148,
                24.99f
        ));

        store.addMedia(new DigitalVideoDisc(
                "Interstellar",
                "Sci-Fi",
                "Christopher Nolan",
                169,
                26.50f
        ));

        store.addMedia(new Book(
                "The Valley of Fear",
                "Detective",
                20.0f
        ));

        store.addMedia(new Book(
                "Clean Code",
                "Programming",
                32.5f
        ));

        store.addMedia(new Book(
                "Design Patterns",
                "Software Engineering",
                40.0f
        ));

        store.addMedia(new CompactDisc(
                "Thriller",
                "Pop",
                "Various",
                "Michael Jackson",
                15.0f
        ));

        store.addMedia(new CompactDisc(
                "Back in Black",
                "Rock",
                "Various",
                "AC/DC",
                14.5f
        ));

        store.addMedia(new CompactDisc(
                "The Dark Side of the Moon",
                "Progressive Rock",
                "Various",
                "Pink Floyd",
                16.0f
        ));


        new StoreScreen(store, cart);
    }
}
