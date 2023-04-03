package room_reservation;

import java.time.LocalDate;

public class Reservation {
    private String name;
    private String surname;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(String name, String surname, LocalDate checkIn, LocalDate checkOut) {
        this.name = name;
        this.surname = surname;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Full Name: " + name + " " + surname +
                ", Check-in: " + checkIn +
                ", Check-out: " + checkOut;
    }
}
