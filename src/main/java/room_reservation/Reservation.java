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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    @Override
    public String toString() {
        return "Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                ", Check-In=" + checkIn +
                ", Check-Out=" + checkOut +
                '}';
    }
}
