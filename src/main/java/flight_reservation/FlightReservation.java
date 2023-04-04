package flight_reservation;

import java.util.Scanner;

public class FlightReservation {
    private static final int numberOfSeats = 10;
    static final boolean[] seatAvailability = new boolean[numberOfSeats];
    private static final Scanner scanner = new Scanner(System.in);

    static void displayMenu() {
        initializeSeats();
        System.out.println("*-- Ash's Flight Reservation App! --*");
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. View available seats");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Cancel a reservation");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            System.out.println("*----------------------------------*");
            switch (choice) {
                case 1 -> viewAvailableSeats();
                case 2 -> reserveSeat();
                case 3 -> cancelReservation();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void initializeSeats() {
        for (int i = 0; i < numberOfSeats; i++) {
            seatAvailability[i] = true; // set all seats to available
        }
    }

    static void viewAvailableSeats() {
        System.out.println("Available seats:");
        for (int i = 0; i < numberOfSeats; i++) {
            if (seatAvailability[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    static void reserveSeat() {
        System.out.println("Enter seat number you wish to reserve:");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > numberOfSeats) {
            System.out.println("Invalid seat number. Please try again.");
            return;
        }
        if (!seatAvailability[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is already taken. Please choose another.");
            return;
        }
        seatAvailability[seatNumber - 1] = false; // mark seat as reserved
        System.out.println("Seat " + seatNumber + " has been reserved.");
    }

    static void cancelReservation() {
        System.out.println("Enter seat number you wish to cancel the reservation for:");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > numberOfSeats) {
            System.out.println("Invalid seat number. Please try again.");
            return;
        }
        if (seatAvailability[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is not reserved. There is no reservation to cancel.");
            return;
        }
        seatAvailability[seatNumber - 1] = true; // mark seat as available
        System.out.println("Reservation for seat " + seatNumber + " has been cancelled.");
    }
}