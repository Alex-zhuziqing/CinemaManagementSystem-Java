package FancyCinemas.DaoTest;

import FancyCinemas.Dao.BookingDao;
import FancyCinemas.Dao.impl.BookingDaoImpl;
import FancyCinemas.Model.Booking;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingDaoTest {
    BookingDao bookingDao = new BookingDaoImpl();

    @Test
    void insertBooking() {
        Booking booking = new Booking("venom", LocalDateTime.now(), 5,10);
        assertTrue(bookingDao.insertBooking(booking));
    }

    @Test
    void getAllBookings() {
        assertNotNull(bookingDao.getAllBookings());
    }

    @Test
    void getMovieBookings() {
        assertNotNull(bookingDao.getMovieBookings("The suicide squad"));
    }
}