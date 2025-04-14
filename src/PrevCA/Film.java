package PrevCA;

/**
 * ClassName: Film
 * Description:
 * <p>
 * Datetime: 2025/4/10 15:21
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Film {
    private int film_id;
    private String genre;
    private String director_name;
    private String title;
    private double length;
    private double rating;


    public Film(int film_id, String genre, String director_name, String title, double length, double rating) {
        this.film_id = film_id;
        this.genre = genre;
        this.director_name = director_name;
        this.title = title;
        this.length = length;
        this.rating = rating;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector_name() {
        return director_name;
    }

    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return
                "film_id=" + film_id +
                ", genre='" + genre + '\'' +
                ", director_name='" + director_name + '\'' +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", rating=" + rating;
    }
}
