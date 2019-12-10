import Reservations.Reservation;

public class BookingApp {
    public static void main(String[] args) {

        Reservation Christmas = new Reservation();
        Reservation NewYears = new Reservation();
        Reservation Easter = new Reservation();

        System.out.println(Christmas.toString());
        System.out.println(NewYears.toString());
        System.out.println(Easter.toString());
    }
}
