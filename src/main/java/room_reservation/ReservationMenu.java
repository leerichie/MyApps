package room_reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationMenu {
    private static final List<Reservation> reservations = new ArrayList<>();

    public static void menu(){
        Scanner input = new Scanner(System.in);
    while(true)

    {
        System.out.println("*------ Ash Hotel ------*");
        System.out.println("1 - Create Reservation");
        System.out.println("2 - View Reservation");
        System.out.println("3 - Delete Reservation");
        System.out.println("0 - Exit");
        System.out.println("*-----------------------*\n");

        int choice = input.nextInt();

        switch (choice) {
            case 1 -> createReservation(input);
            case 2 -> viewReservation(input);
            case 3 -> deleteReservation(input);
            case 0 -> System.exit(0);
            default -> System.out.println("Invalid choice, try again!");
        }
        }
    }

    private static void createReservation(Scanner input) {
        System.out.println("*--- New Reservation ---*");
        System.out.println("Enter First Name:");
        String name = input.next();
        System.out.println("Enter Surname:");
        String surname = input.next();
        System.out.println("Enter check-in date (dd/mm/yyyy):");
        String inDate = input.next();
        LocalDate checkInDate = LocalDate.parse(inDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Enter check-out date (dd/mm/yyyy):");
        String outDate = input.next();
        LocalDate checkOutDate = LocalDate.parse(outDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Reservation details: \n" + "Customer: " + name + " " + surname + "\n"
                                + "Check-in: " + checkInDate + "\n" + "Check-out: " + checkOutDate);
        System.out.println("Reservation completed!");
        Reservation reservation = new Reservation(name, surname, checkInDate, checkOutDate);
        reservations.add(reservation);
        System.out.println("*------------------------*\n");
    }

    private static void viewReservation(Scanner input){
        System.out.println("*--- View Reservations ---*");
        if(reservations.isEmpty()){
            System.out.println("No reservations found!");
        } else {
            System.out.println("Reservations:");
            for (Reservation reservation : reservations){
                System.out.println(reservation);

            }
        }
        System.out.println("*------------------------*\n");
    }

    private static void deleteReservation(Scanner input){
        System.out.println("*--- Delete Reservation ---*");

        System.out.println("*--------------------------*\n");
    }
}
