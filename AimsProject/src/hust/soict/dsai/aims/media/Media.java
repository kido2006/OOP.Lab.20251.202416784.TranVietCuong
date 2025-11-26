package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {

	private static int currentId = 0;

    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    // Constructor
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
        this(title, category);
        this.cost = cost;
    }

    //Get & Set
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Media)) return false;

        Media other = (Media) obj;

        return this.title != null && this.title.equals(other.getTitle());
    }
    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    
}
