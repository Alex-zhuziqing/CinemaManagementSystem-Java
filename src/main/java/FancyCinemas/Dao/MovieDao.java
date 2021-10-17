package FancyCinemas.Dao;

import FancyCinemas.Model.Movie;
import java.util.List;

public interface MovieDao {
    /**
     * Get a movie by given movie name
     * @param movieName
     * @return
     */
    public Movie getMovieByName(String movieName);

    /**
     * Get all movies' name
     * @return
     */
    public List<String> getAllMovieName();
    /**
     * Get all the movies that has less restriction than classification given
     * @param classification classification short name like "R18+"
     * @return
     */
    public List<Movie> filterMovieByClassification(String classification);

    /**
     * Insert a new movie to database
     * @param movie
     * @return
     */
    public Boolean insertNewMovie(Movie movie);

    /**
     * Delete a movie from database
     * @param movieName
     * @return
     */
    public Boolean deleteMovie(String movieName);
    public Boolean modifyMovieName(String movieName, String newMovieName);
    public Boolean modifySynopsis(String movieName, String newSynopsis);
    public Boolean modifyClassification(String movieName, String newClassification) ;
    public Boolean modifyReleaseDate(String movieName, String newDate);
    public Boolean modifyDirector(String movieName, String newDirector);
    public Boolean modifyCast(String movieName, String newCast);
    public Boolean modifyScreenSize(String movieName, String screenSize, Integer price);
}
