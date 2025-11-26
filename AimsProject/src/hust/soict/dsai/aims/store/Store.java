package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (media == null) return;
        itemsInStore.add(media);
        System.out.println("Added to store: " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed from store: " + media.getTitle());
        } else {
            System.out.println("Media not found in store.");
        }
    }

    public void printStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("Store is empty!");
            return;
        }

        System.out.println("*************** STORE ITEMS ***************");
        int index = 1;
        for (Media m : itemsInStore) {
            System.out.println(index + ". " + m.toString());
            index++;
        }
        System.out.println("********************************************");
    }

    public Media searchMediaByTitle(String title) {
        if (title == null) return null;
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }
}
