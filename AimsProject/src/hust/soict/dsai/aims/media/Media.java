package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {

    private static int currentId = 0;

    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public Media() {
        currentId++;
        this.id = currentId;
    }

    public Media(String title) {
        this();
        this.title = title;
    }

    public Media(String title, String category) {
        this(title);
        this.category = category;
    }

    public Media(String title, String category, float cost) {
    	this();
        if (cost < 0) {
            throw new IllegalArgumentException("Cost must be non-negative");
        }
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Media)) return false;

        Media other = (Media) obj;

        if (this.title == null || other.title == null) return false;
        return this.title.equals(other.title);
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();

    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();
}
