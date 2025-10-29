
public class Store {


	public static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int numberOfItems = 0;

    public void addDVD(DigitalVideoDisc disc) {
        if (numberOfItems < MAX_ITEMS_IN_STORE) {
            itemsInStore[numberOfItems] = disc;
            numberOfItems++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more discs.");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < numberOfItems; i++) {
            if (itemsInStore[i].equals(disc)) {
                for (int j = i; j < numberOfItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[numberOfItems - 1] = null;
                numberOfItems--;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed from the store.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Disc not found in the store.");
        }
    }

    public void printStore() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < numberOfItems; i++) {
            DigitalVideoDisc disc = itemsInStore[i];
            System.out.println((i + 1) + ".DVD - " 
                + disc.getTitle() + " - " 
                + disc.getCategory() + " - " 
                + disc.getDirector() + " - " 
                + disc.getLength() + ": " 
                + disc.getCost() + " $ ");
        }
        System.out.println("***************************************************");
    }

	

}
