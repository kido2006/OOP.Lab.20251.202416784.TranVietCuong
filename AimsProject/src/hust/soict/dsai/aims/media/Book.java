package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<>();

    // Constructors
    public Book() {
        super();
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author " + authorName + " is already in the list!");
        } else {
            authors.add(authorName);
            System.out.println("Author: " + authorName + " added!");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author " + authorName + " removed!");
        } else {
            System.out.println("Author " + authorName + " is not in the list!");
        }
    }

    @Override
    public String toString() {
        return "Book - Title: " + getTitle()
                + " | Category: " + getCategory()
                + " | Cost: " + getCost() + "$"
                + " | Authors: " + authors;
    }
}
