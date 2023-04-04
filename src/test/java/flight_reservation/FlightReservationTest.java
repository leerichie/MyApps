package flight_reservation;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FlightReservationTest {

    @Test
    public void testViewAvailableSeats() {
        // Test that the viewAvailableSeats method returns a list of all available seats
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FlightReservation.initializeSeats();
        FlightReservation.viewAvailableSeats();
        assertEquals("Available seats:\n1 2 3 4 5 6 7 8 9 10 \n", outputStream.toString());
    }

    @Test
    public void testReserveSeat() {
        // Test that a seat can be successfully reserved
        String input = "5\n"; // Simulate user input for seat number 5
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // Redirect System.in to use the simulated input

        FlightReservation.initializeSeats();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent)); // Redirect System.out to capture the console output
        FlightReservation.reserveSeat();
        assertFalse(FlightReservation.seatAvailability[4]); // Check that the seat is no longer available
        assertEquals("Enter seat number you wish to reserve:\nSeat 5 has been reserved.\n", outContent.toString()); // Check that the correct output was printed
    }
}