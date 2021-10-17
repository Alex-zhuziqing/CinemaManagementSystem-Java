package FancyCinemas.Model;

import FancyCinemas.Utils.ModelUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Movie {
    private String movieName;
    private String synopsis;
    private MovieClassification classification;
    private LocalDate releaseDate;
    private String director;
    private String cast;
    private ArrayList<LocalDateTime> upcomingTimes;
    private ArrayList<SizePricePair> screenSize;

    public Movie() {
    }

    public Movie(String[] list) {
        this.movieName = list[0];
        this.synopsis = list[1];
        this.classification = ModelUtil.stringToClassification(list[2]);
        this.releaseDate = ModelUtil.stringToDate(list[3]);
        this.director = list[4];
        this.cast = list[5];
        ArrayList<SizePricePair> pairList = new ArrayList<>();
        for (String s : list[6].split(",")) {
            pairList.add(ModelUtil.stringToPair(s));
        }
        this.screenSize = pairList;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }



    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public MovieClassification getClassification() {
        return classification;
    }

    public void setClassification(MovieClassification classification) {
        this.classification = classification;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<LocalDateTime> getUpcomingTimes() {
        return upcomingTimes;
    }

    public void setUpcomingTimes(ArrayList<LocalDateTime> upcomingTimes) {
        this.upcomingTimes = upcomingTimes;
    }

    public ArrayList<SizePricePair> getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(ArrayList<SizePricePair> screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", classification='" + classification + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", director='" + director + '\'' +
                ", cast='" + cast + '\'' +
                ", upcomingTimes='" + upcomingTimes + '\'' +
                ", screenSize='" + screenSize + '\'' +
                '}';
    }
}
