package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Cart anOrder = new Cart();
//
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation" , "Roger Allers" , 87, 19.95f);
//        anOrder.addDigitalVideoDisc(dvd1);
//
//        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction" , "George Lucas" , 87, 24.95f);
//        anOrder.addDigitalVideoDisc(dvd2);
//        
//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation" , 18.99f);
//        anOrder.addDigitalVideoDisc(dvd3);
//
//        anOrder.removeDigitalVideoDisc(dvd2);
//        
//        System.out.print("Total cost is: ");
//        System.out.println(anOrder.totalCost());

        
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation" , "Roger Allers" , 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction" , "George Lucas" , 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation" , 18.99f);
        
        // Test 1: add 1 dvd
        cart.addDigitalVideoDisc(dvd1);

        // Test 2: add 2 dvd
        cart.addDigitalVideoDisc(dvd2, dvd3);

        // Test 4: use varargs
        cart.addDigitalVideoDisc(dvd1, dvd2, dvd3);
        
		System.out.print("Total cost is: ");
		System.out.println(cart.totalCost());
		
        System.out.println("Total number of DVDs: " + DigitalVideoDisc.getNbDigitalVideoDiscs());

        System.out.println("DVD1 ID: " + dvd1.getId());
        System.out.println("DVD2 ID: " + dvd2.getId());
        System.out.println("DVD3 ID: " + dvd3.getId());
	}

}
