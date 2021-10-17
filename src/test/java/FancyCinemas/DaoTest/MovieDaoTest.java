package FancyCinemas.DaoTest;

import FancyCinemas.Dao.MovieDao;
import FancyCinemas.Dao.impl.MovieDaoImpl;
import FancyCinemas.Model.Movie;
import FancyCinemas.Model.MovieClassification;
import FancyCinemas.Model.SizePricePair;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieDaoTest {
    MovieDao movieDao = new MovieDaoImpl();

    @Test
    void getMovieByName() {
        assertNotNull(movieDao.getMovieByName("The suicide squad"));
    }

    @Test
    void getAllMovieName() {
        assertNotNull(movieDao.getAllMovieName());
    }

    @Test
    void filterMovieByClassification() {
        assertNotNull(movieDao.filterMovieByClassification("R18+"));
    }

    @Test
    void insertNewMovie() {
        Movie movie = new Movie();
        movie.setMovieName("Your Name");
        movie.setSynopsis("In the fall of 2013, Mitsuha Miyamizu is a high school girl living in the rural town of Itomori in Japan. Bored of the town, she wishes to be a Tokyo boy in her next life.");
        movie.setClassification(MovieClassification.GENERAL);
        movie.setReleaseDate(LocalDate.of(2016, 7, 3));
        movie.setDirector("Makoto Shinkai");
        movie.setCast("Mitsuha Miyamizu,Taki Tachibana");
        ArrayList<LocalDateTime> list = new ArrayList<>();
        list.add(LocalDateTime.of(2022, 10, 3, 1, 2));
        movie.setUpcomingTimes(list);
        ArrayList<SizePricePair> ls = new ArrayList<>();
        ls.add(new SizePricePair("Bold", 100));
        movie.setScreenSize(ls);
        assertTrue(movieDao.insertNewMovie(movie));

    }

    @Test
    void deleteMovie() {
        assertTrue(movieDao.deleteMovie("Your Name"));
    }

    @Test
    void modifyMovieName() {
        assertTrue(movieDao.modifyMovieName("The suicide squad", "The suicide squad"));
    }

    @Test
    void modifySynopsis() {
        assertTrue(movieDao.modifySynopsis("The suicide squad", "Welcome to hell: .k.a. Belle Reve, the prison with the highest mortality rate in the US of A."));
    }

    @Test
    void modifyClassification() {
        assertTrue(movieDao.modifyClassification("The suicide squad", "R18+"));
    }

    @Test
    void modifyReleaseDate() {
        assertTrue(movieDao.modifyReleaseDate("The suicide squad", "2021-08-30"));
    }

    @Test
    void modifyDirector() {
        assertTrue(movieDao.modifyDirector("The suicide squad", "James Gunn"));
    }

    @Test
    void modifyCast() {
        assertTrue(movieDao.modifyCast("The suicide squad", "Sylvester Stallone, Jai Courtney, Viola Davis, Nathan Fillion, Idris Elba, Alice Braga"));
    }

    @Test
    void modifyScreenSize() {
        assertTrue(movieDao.modifyScreenSize("The suicide squad", "Bold", 60));
    }
}