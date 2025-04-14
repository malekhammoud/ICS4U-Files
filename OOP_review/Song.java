package OOP_review;

public class Song {
    private String title;
    private String artist;
    Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String[] getSong() {
        return new String[] { title, artist };
    }
    public String toString() {
        return title + ", " + artist;
    }
    public boolean equal(Song song) {
        return this.title.equals(song.title);
    }
}
