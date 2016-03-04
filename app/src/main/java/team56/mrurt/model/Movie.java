package team56.mrurt.model;
import java.io.Serializable;


public class Movie implements Serializable {
    String title, year, synopsis, criticsRating;
    int userRating;

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
     * @param userRating is critics rating
     */
    public void setUserRating(int userRating) {
        this.userRating = userRating;
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
     * Gets critics rating
     * @return the rating.
     */
    public int getUserRating() {
        return this.userRating;
    }


    /**
     * Gets movie title and year.
     * @return a string that contains title and year of movie.
     */
    public String toString() {
        return (getTitle() + " (" + getYear() + ") " + getCriticsRating() + " %");
    }
}
