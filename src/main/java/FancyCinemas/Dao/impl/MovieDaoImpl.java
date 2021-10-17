package FancyCinemas.Dao.impl;

import FancyCinemas.Dao.MovieDao;
import FancyCinemas.Model.Booking;
import FancyCinemas.Model.Movie;
import FancyCinemas.Model.MovieClassification;
import FancyCinemas.Utils.ModelUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MovieDaoImpl extends BaseDao implements MovieDao {
    private final String fileName = "src/main/resources/movies.txt";
    BookingDaoImpl bookingDao = new BookingDaoImpl();

    public Movie getMovieByName(String movieName) {
        Movie movie = getElement(fileName, 0, movieName, Movie::new);
        ArrayList<Booking> movieBookings = bookingDao.getMovieBookings(movieName);
        List<LocalDateTime> collect = movieBookings.stream().map(Booking::getTime).collect(Collectors.toList());
        movie.setUpcomingTimes((ArrayList<LocalDateTime>) collect);
        return movie;
    }

    public List<String> getAllMovieName() {
        ArrayList<String> list = getAllElements("src/main/resources/bookings.txt", s -> s[0]);
        return list.stream().distinct().collect(Collectors.toList());
    }

    public List<Movie> filterMovieByClassification(String classification) {
        Integer limitVal = MovieClassification.getClassVal(classification);
        ArrayList<Movie> movies = getAllElements(fileName, Movie::new);
        Stream<Movie> movieStream = movies.stream();
        return movieStream
                .filter(movie -> movie.getClassification().classVal < limitVal)
                .peek(movie -> {
                    ArrayList<Booking> movieBookings = bookingDao.getMovieBookings(movie.getMovieName());
                    List<LocalDateTime> collect = movieBookings.stream().map(Booking::getTime).collect(Collectors.toList());
                    movie.setUpcomingTimes((ArrayList<LocalDateTime>) collect);
                })
                .collect(Collectors.toList());
    }

    public Boolean insertNewMovie(Movie movie) {
        String movieName = movie.getMovieName();
        String synopsis = movie.getSynopsis();
        String classification = movie.getClassification().shortName;
        String release_date = ModelUtil.dateToString(movie.getReleaseDate());
        String director = movie.getDirector();
        String cast = movie.getCast();
        String screenSize = ModelUtil.pairListToString(movie.getScreenSize());
        String newRow = movieName + "/" + synopsis + "/" + classification + "/" + release_date + "/" + director + "/" + cast + "/" + screenSize;
        for (LocalDateTime time : movie.getUpcomingTimes()) {
            Booking booking = new Booking(movieName, time, 0, Booking.DEFAULT_SEATS_AVAILABLE);
            bookingDao.insertBooking(booking);
        }
        return insertNewRow(fileName, newRow);
    }

    public Boolean deleteMovie(String movieName) {
        return deleteRow(fileName, 0, movieName) & deleteRow("src/main/resources/bookings.txt", 0, movieName);
    }

    public Boolean modifyMovieName(String movieName, String newMovieName) {
        return updateElement(fileName, movieName, 0, s -> newMovieName);
    }

    public Boolean modifySynopsis(String movieName, String newSynopsis) {
        return updateElement(fileName, movieName, 1, s -> newSynopsis);
    }

    public Boolean modifyClassification(String movieName, String newClassification) {
        return updateElement(fileName, movieName, 2, s -> newClassification);
    }

    public Boolean modifyReleaseDate(String movieName, String newDate) {
        return updateElement(fileName, movieName, 3, s -> newDate);
    }

    public Boolean modifyDirector(String movieName, String newDirector) {
        return updateElement(fileName, movieName, 4, s -> newDirector);
    }

    public Boolean modifyCast(String movieName, String newCast) {
        return updateElement(fileName, movieName, 5, s -> newCast);
    }

    public Boolean modifyScreenSize(String movieName, String screenSize, Integer price) {
        return updateElement(fileName, movieName, 6, s -> {
            if (!s.contains(screenSize)) {
                return s + "," + screenSize + "#" + price;
            }
            String[] pairs = s.split(",");
            for (int i = 0; i < pairs.length; i++) {
                if (pairs[i].contains(screenSize)) {
                    pairs[i] = screenSize + "#" + price;
                }
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < pairs.length; i++) {
                if (i == pairs.length - 1) {
                    sb.append(pairs[i]);
                } else {
                    sb.append(pairs[i] + ",");
                }
            }
            return sb.toString();
        });
    }
}
