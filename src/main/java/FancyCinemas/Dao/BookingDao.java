package FancyCinemas.Dao;

import FancyCinemas.Model.Booking;

import java.util.ArrayList;

public interface BookingDao {
    /**
     * Insert a booking into Database
     * @param booking
     * @return
     */
    public Boolean insertBooking(Booking booking);
    /**
     * Get all the booking details
     * @return
     */
    public ArrayList<Booking> getAllBookings();

    /**
     * Get all the booking details of a movie
     * @param movieName
     * @return
     */
    public ArrayList<Booking> getMovieBookings(String movieName);
}
