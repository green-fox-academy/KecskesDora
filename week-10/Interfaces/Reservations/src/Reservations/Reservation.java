package Reservations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;

public class Reservation implements Reservationy {

    private static final String NAME = "Booking#";
    private static final ArrayList<String> DOW = new ArrayList<>(Arrays.asList("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"));

    public void Reservation(){

    }

    @Override
    public String getDowBooking() {
        int dayOfWeek = (int)(Math.random() * DOW.size());
        return DOW.get(dayOfWeek);
    }

    @Override
    public String getCodeBooking() {
        String bookingCode = "";
        String lettersAndNumber = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rd = new Random();
        for (int i = 0; i < 8; i++) {
            bookingCode += lettersAndNumber.charAt(rd.nextInt(lettersAndNumber.length()));
        }
        return bookingCode;
    }

    @Override
    public String toString() {
        StringBuilder bookingDetails = new StringBuilder();
        Formatter f = new Formatter(bookingDetails);
        f.format("%s %s for %s", NAME, getCodeBooking(), getDowBooking());
        return bookingDetails.toString();
    }
}
