
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
}
