package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media a, Media b) {
        // Title ASC
        int titleCompare = a.getTitle().compareToIgnoreCase(b.getTitle());
        if (titleCompare != 0) {
            return titleCompare;
        }

        // Cost DESC
        return Float.compare(b.getCost(), a.getCost());
    }
}
