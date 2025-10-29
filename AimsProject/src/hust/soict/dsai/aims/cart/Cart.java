package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED=20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int quantityOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(quantityOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[quantityOrdered] = disc;
			quantityOrdered += 1;
			System.out.println("The disc has been added.");
		}
		else {
			System.out.println("The cart is almost full.");
		}
	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//		for(DigitalVideoDisc disc : dvdList) {
//			addDigitalVideoDisc(disc);
//		}
//	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
	    for (DigitalVideoDisc disc : dvds) {
	        addDigitalVideoDisc(disc);
	    }
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
	    addDigitalVideoDisc(dvd1);
	    addDigitalVideoDisc(dvd2);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i=0; i< quantityOrdered; i++) {
			if(itemsOrdered[i] == disc) {
				for(int j=i; j < quantityOrdered-1; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				quantityOrdered -=1;
				System.out.println("The disc has been removed.");
				return;
			}
		}
		System.out.println("Disc not found.");
	}
	
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < quantityOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    
    public void printCart() {
    	System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < quantityOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println((i + 1) + ".DVD - " 
                + disc.getTitle() + " - " 
                + disc.getCategory() + " - " 
                + disc.getDirector() + " - " 
                + disc.getLength() + ": " 
                + disc.getCost() + " $ ");
        }

        System.out.println("Total cost: " + totalCost() + " $ ");
        System.out.println("***************************************************");
    }
    
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < quantityOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found: " + itemsOrdered[i].getTitle()+"\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id+"\n");
        }
    }
    
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < quantityOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found: " + itemsOrdered[i].getTitle()+"\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title +"\n");
        }
    }

}
