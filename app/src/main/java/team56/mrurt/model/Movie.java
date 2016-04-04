package team56.mrurt.model;
import java.io.Serializable;
import java.util.List;
import java.lang.Comparable;


public class Movie implements Serializable, Comparable<Movie> {
    String title, year, synopsis, criticsRating, id;
    double userRatings;
    static float numOfUsers, total;
    List<String> genres, ratingMajor;

    /**
     * Sets Movie title.
     * @param title is movie title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets Movie release year.
     * @param year is release year of movie.
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Sets Movie synopsis.
     * @param synopsis movie synopsis.
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Sets critics rating
     * @param criticsRating is critics rating
     */
    public void setCriticsRating(String criticsRating) {
        this.criticsRating = criticsRating;
    }

    /**
     * Gets Movie title.
     * @return the title.
     */

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    /**
     * Gets Move release year.
     * @return the year.
     */
    public String getYear() {
        return this.year;
    }

    /**
     * Gets Movie synopsis.
     * @return the synopsis.
     */
    public String getSynopsis() {
        return this.synopsis;
    }

    /**
     * Gets critics rating
     * @return the rating.
     */
    public String getCriticsRating() {
        return this.criticsRating;
    }

    /**
     * Gets movie title and year.
     * @return a string that contains title and year of movie.
     */

    public String getId() {
        return this.id;
    }

    public String toString() {
        return (getTitle() + " (" + getYear() + ") " + getCriticsRating() + " %");
    }

    @Override
    public int compareTo(Movie a) {
        return (int) this.userRatings - (int) a.userRatings;
    }

    public boolean equals(Object o) {
        Movie m = (Movie) o;
        if(m.getTitle().equals(this.title)) {
            return true;
        }
        return false;
    }
}
