package FancyCinemas.Dao.impl;

import FancyCinemas.Dao.BookingDao;
import FancyCinemas.Model.Booking;
import FancyCinemas.Utils.ModelUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class BookingDaoImpl extends BaseDao implements BookingDao {
    private final String fileName = "src/main/resources/bookings.txt";

    public Boolean insertBooking(Booking booking) {
        String newRow = booking.getMovieName() + "/" + ModelUtil.dateTimeToString(booking.getTime()) + "/" + booking.getSeatsBooked() + "/" + booking.getSeatsAvailable();
        return insertNewRow(fileName, newRow);
    }

    public ArrayList<Booking> getAllBookings() {
        return getBookings("", s -> true);
    }

    public ArrayList<Booking> getMovieBookings(String movieName) {
        return getBookings(movieName, s -> s.equals(movieName));
    }

    public ArrayList<Booking> getBookings(String movieName, Predicate<String> predicate) {
        Scanner sc = null;
        // array that store all the contents of database
        ArrayList<String> fileLines = new ArrayList<>();
        ArrayList<Booking> list = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        // Read all the contents of database into the array
        try {
            sc = new Scanner(new File(fileName));
            //add the header
            fileLines.add(sc.nextLine());
            //read in previous rows
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineInfo = line.split("/");
                LocalDateTime bookingTime = ModelUtil.stringToDateTime(lineInfo[1]);
                //The time is still valid
                if (bookingTime.isAfter(now)) {
                    fileLines.add(line);
                    if (predicate.test(lineInfo[0])) {
                        list.add(new Booking(lineInfo[0], bookingTime, Integer.parseInt(lineInfo[2]), Integer.parseInt(lineInfo[3])));
                    }
                }
            }

        }
        // If have error when read in contents of database, stop and return false
        catch (Exception e) {
            return null;
        }
        // Update the content of database
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);
            for (String s : fileLines) {
                fw.write(s + "\n");
            }
        } catch (IOException e) {
            return null;
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
