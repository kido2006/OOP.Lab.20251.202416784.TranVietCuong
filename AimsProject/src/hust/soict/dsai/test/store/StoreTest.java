package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {

        Store store = new Store();

        // Add DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);

        // Print store contents
        System.out.println("\nSTORE AFTER ADDING ITEMS");
        store.printStore();

        // Remove one DVD
        store.removeMedia(dvd2);

        // Print again
        System.out.println("\nSTORE AFTER REMOVING 'Star Wars'");
        store.printStore();
    }
}
