package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(title, category, director, 0, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (track == null) return;

        if (tracks.contains(track)) {
            System.out.println("Track already exists: " + track.getTitle());
        } else {
            tracks.add(track);
            System.out.println("Added track: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (track == null) return;

        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Removed track: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    @Override
    public int getLength() {
        int total = 0;
        for (Track t : tracks) total += t.getLength();
        return total;
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive");
        }

        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Total length: " + this.getLength());

        for (Track t : tracks) {
            t.play(); // may throw PlayerException
        }
    }

    @Override
    public String toString() {
        return getId() + " - CD: " + getTitle()
                + " - Category: " + getCategory()
                + " - Director: " + getDirector()
                + " - Artist: " + artist
                + " - Length: " + getLength()
                + " - Cost: " + getCost() + "$";
    }
}
