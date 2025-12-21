package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {

    private Store store = new Store();
    private Cart cart = new Cart();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Aims app = new Aims();
        app.initStore();
        app.showMenu();
    }

    private void initStore() {
        store.addMedia(new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc(
                "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc(
                "Aladin", "Animation", "John Musker", 90, 18.99f));

        store.addMedia(new Book("The Valley of Fear", "Detective", 20.0f));

        CompactDisc cd = new CompactDisc("30", "Music", "Unknown", "Adele", 15.0f);
        cd.addTrack(new Track("All Night Parking", 161));
        cd.addTrack(new Track("To Be Loved", 403));
        store.addMedia(cd);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nAIMS:");
            System.out.println("1. View store");
            System.out.println("2. See current cart");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = readInt();
            switch (choice) {
                case 1 -> storeMenu();
                case 2 -> cartMenu();
                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print("Number only: ");
        }
        int x = scanner.nextInt();
        scanner.nextLine();
        return x;
    }

    public void storeMenu() {
        while (true) {
            store.printStore();
            System.out.println("\nStore Options:");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int choice = readInt();
            switch (choice) {
                case 1 -> seeMediaDetails();
                case 2 -> addMediaToCartFromStore();
                case 3 -> playMediaFromStore();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void seeMediaDetails() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        Media media = store.searchMediaByTitle(title);
        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        System.out.println("\nDetails: " + media);
        mediaDetailsMenu(media);
    }

    public void mediaDetailsMenu(Media media) {
        while (true) {
            System.out.println("\n1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int choice = readInt();
            switch (choice) {
                case 1 -> {
                    try {
                        cart.addMedia(media);
                    } catch (LimitExceededException e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
                case 2 -> {
                    if (media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            System.err.println(e.getMessage());
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addMediaToCartFromStore() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            try {
                cart.addMedia(media);
            } catch (LimitExceededException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    private void playMediaFromStore() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        Media media = store.searchMediaByTitle(title);
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Not playable or not found.");
        }
    }

    public void cartMenu() {
        while (true) {
            cart.printCart();
            System.out.println("\nCart Options:");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int choice = readInt();
            switch (choice) {
                case 1 -> filterCart();
                case 2 -> sortCart();
                case 3 -> removeFromCart();
                case 4 -> playMediaFromCart();
                case 5 -> placeOrder();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void filterCart() {
        System.out.println("Filter by: 1-ID | 2-Title");
        int choice = readInt();

        if (choice == 1) {
            System.out.print("Enter ID: ");
            cart.searchById(readInt());
        } else if (choice == 2) {
            System.out.print("Enter title: ");
            cart.searchByTitle(scanner.nextLine());
        }
    }

    private void sortCart() {
        System.out.println("Sort by: 1-Title | 2-Cost");
        int c = readInt();

        if (c == 1) cart.sortMediaByTitle();
        else cart.sortMediaByCost();

        cart.printCart();
    }

    private void removeFromCart() {
        System.out.print("Enter title: ");
        cart.removeMedia(scanner.nextLine());
    }

    private void playMediaFromCart() {
        System.out.print("Enter title: ");
        cart.playMedia(scanner.nextLine());
    }

    private void placeOrder() {
        System.out.println("Order created!");
        cart.empty();
    }
}
