import Reservations.Reservation;

public class BookingApp {
    public static void main(String[] args) {

        Reservation christmas = new Reservation();
        Reservation newYears = new Reservation();
        Reservation easter = new Reservation();

        System.out.println(christmas.toString());
        System.out.println(newYears.toString());
        System.out.println(easter.toString());
    }
}
