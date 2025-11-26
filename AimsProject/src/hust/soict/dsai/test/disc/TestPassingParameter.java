package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        System.out.println("Before swap:");
        System.out.println("jungle: " + jungleDVD.getTitle());
        System.out.println("cinderella: " + cinderellaDVD.getTitle());

        swap(jungleDVD, cinderellaDVD);

        System.out.println("\nAfter WRONG swap:");
        System.out.println("jungle: " + jungleDVD.getTitle());
        System.out.println("cinderella: " + cinderellaDVD.getTitle());

        // swap đúng
        swapTitle(jungleDVD, cinderellaDVD);

        System.out.println("\nAfter CORRECT swapTitle:");
        System.out.println("jungle: " + jungleDVD.getTitle());
        System.out.println("cinderella: " + cinderellaDVD.getTitle());

        // changeTitle test
        changeTitle(jungleDVD, "New Title");

        System.out.println("\nAfter changeTitle(jungleDVD, \"New Title\"):");
        System.out.println("jungle: " + jungleDVD.getTitle());

    }

    //swap sai
    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        DigitalVideoDisc tmp = o1;
        o1 = o2;
        o2 = tmp;
      
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String old = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(old);    
    }

    // swap đúng
    public static void swapTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tmp = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tmp);
    }
}
