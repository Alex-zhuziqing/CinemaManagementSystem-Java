package FancyCinemas.Model;

import java.time.LocalDateTime;

public class Booking {
    private String movieName;
    private LocalDateTime time;
    private Integer seatsBooked;
    private Integer seatsAvailable;
    public static Integer DEFAULT_SEATS_AVAILABLE = 50;

    public Booking() {
    }

    public Booking(String movieName, LocalDateTime time, Integer seatsBooked, Integer seatsAvailable) {
        this.movieName = movieName;
        this.time = time;
        this.seatsBooked = seatsBooked;
        this.seatsAvailable = seatsAvailable;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(Integer seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public Integer getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(Integer seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "movieName='" + movieName + '\'' +
                ", time=" + time +
                ", seatsBooked=" + seatsBooked +
                ", seatsAvailable=" + seatsAvailable +
                '}';
    }
}
