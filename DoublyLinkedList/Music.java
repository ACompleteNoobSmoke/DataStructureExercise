public class Music {

    private String title;
    private String artist;
    private int year;

    public Music(String title, String artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    public String toString() {
        return "Title: " + title + "\n" + "Artist: " + artist + "\n" + "Year: " + year + "\n";
    }

}