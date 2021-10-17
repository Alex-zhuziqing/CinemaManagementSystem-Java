package FancyCinemas.Utils;

import FancyCinemas.Model.MovieClassification;
import FancyCinemas.Model.SizePricePair;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ModelUtil {
    /**
     * Convert short name (like "R18+") to MovieClassification
     * @param strClassification "R18+"or"G"...
     * @return a MovieClassification object
     */
    public static MovieClassification stringToClassification(String strClassification) {
        for (MovieClassification m : MovieClassification.values()) {
            if (m.shortName.equals(strClassification)) {
                return m;
            }
        }
        return null;
    }

    public static LocalDate stringToDate(String strDate) {
        String[] dateNums = strDate.split("-");
        int year = Integer.parseInt(dateNums[0]);
        int month = Integer.parseInt(dateNums[1]);
        int day = Integer.parseInt(dateNums[2]);
        return LocalDate.of(year, month, day);
    }

    /**
     * Convert string (like "2021-10-15 04:47") to LocalDateTime object
     * @param strDateTime
     * @return
     */
    public static LocalDateTime stringToDateTime(String strDateTime) {
        String[] tmp = strDateTime.split(" ");
        String[] dateNums = tmp[0].split("-");
        int year = Integer.parseInt(dateNums[0]);
        int month = Integer.parseInt(dateNums[1]);
        int day = Integer.parseInt(dateNums[2]);
        String[] timeNums = tmp[1].split(":");
        int hour = Integer.parseInt(timeNums[0]);
        int minute = Integer.parseInt(timeNums[1]);
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    /**
     * Conver LocalDate object to string like "2021-9-21"
     * @param date
     * @return
     */
    public static String dateToString(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTimeFormatter.format(date);
    }

    public static String dateTimeToString(LocalDateTime date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
        return dateTimeFormatter.format(date);
    }


    /**
     * Convert string (like "Gold#35") to SizePricePair object
     * @param strPair
     * @return
     */
    public static SizePricePair stringToPair(String strPair) {
        String[] s = strPair.split("#");
        return new SizePricePair(s[0], Integer.parseInt(s[1]));
    }

    /**
     * Convert a list of SizePricePair objects to a string (like "Gold#25,Bold#21,Silver#27")
     * @param list
     * @return
     */
    public static String pairListToString(ArrayList<SizePricePair> list) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i).toString());
            } else {
                sb.append(list.get(i).toString() + ",");
            }
        }
        return sb.toString();
    }

}
