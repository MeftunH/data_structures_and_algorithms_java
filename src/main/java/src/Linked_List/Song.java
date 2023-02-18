package src.Linked_List;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

public class Song {
    private String title;
    private String artist;
    private int duration; // in seconds

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    // getters and setters
    // ...
}

