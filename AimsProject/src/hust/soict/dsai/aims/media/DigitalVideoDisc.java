package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    // Constructor
    public DigitalVideoDisc(String title) {
        super(title, "No category", "No director", 0, 0f);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, "No director", 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    @Override
    public void play() {
        if (getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.out.println("ERROR: DVD length is non-positive");
        }
    }

    @Override
    public String toString() {
        return getId() + " - DVD: " + getTitle()
                + " - Category: " + getCategory()
                + " - Director: " + getDirector()
                + " - Length: " + getLength()
                + " - Cost: " + getCost() + "$";
    }
}
