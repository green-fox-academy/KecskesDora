import Reservations.Reservation;

public class BookingApp {
    public static void main(String[] args) {

        Reservation reservation = new Reservation();

        for (int i = 0; i < 10; i++) {
            System.out.println(reservation.toString());
        }
    }
}
