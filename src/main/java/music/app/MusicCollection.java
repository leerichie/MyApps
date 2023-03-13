package music.app;

import java.util.HashMap;
import java.util.Scanner;

public class MusicCollection {
    public static Scanner input = new Scanner(System.in);
    public static HashMap<Integer, String> playlist = new HashMap<>();

    public static void main(String[] args) {
        menu();
    }

//    static void scanner(Scanner input) {
//        int menuChoice;
//        do {
//            System.out.println("Press 0 to return to main menu");
//            menuChoice = input.nextInt();
//            System.out.println("Invalid choice, try again");
//        }
//        while (menuChoice != 0);
//        menu();
//    }

    static void menu() {
//        playlist.put(1, "Mia");
//        playlist.put(2, "Elton John");
//        playlist.put(3, "Shirley Bassey");

        int option = 0;
        do {
            System.out.println("------- MENU ------");
            System.out.println("1 - Display tracks");
            System.out.println("2 - Add tracks");
            System.out.println("3 - Search tracks");
            System.out.println("4 - Edit tracks");
            System.out.println("5 - Delete tracks");
            System.out.println("0 - Exit");
            System.out.println("------ @sh ------");
        }
        while (option != 0);
        option = input.nextInt();

        switch (option) {
            case 1:
                display();
                break;
            case 2:
                add(input);
                break;
            case 3:
                search(input);
                break;
            case 4:
                edit(input);
                break;
            case 5:
                delete(input);
                break;
            default:
                System.out.println("Goodbye :)");
        }
    }

    static void display() {
        System.out.println("--- COLLECTION ---");
        for (int i : playlist.keySet()) {
            System.out.println(i + " " + playlist.get(i));
        }
        menu();
    }

    static void add(Scanner input) {
        System.out.println("------ ADD ------");
        System.out.println("Track number:");
        int index = input.nextInt();
        System.out.println("Artist name:");
        String artist = input.next();
        if (!playlist.containsKey(index) && !playlist.containsValue(artist)) {
            playlist.put(index, artist);
            System.out.println("Added: " + index + " " + artist);
        } else {
            System.out.println("ID or Artist already exists");
            add(input);
        }
        menu();
    }

    static void search(Scanner input) {
        System.out.println("------ SEARCH ------");
        System.out.println("Search by Index press 0 or Artist press 1");
        int indexOrArtist = input.nextInt();
        int index = 0;
        String artist;
        if (indexOrArtist != 0 && indexOrArtist != 1) {
            System.out.println("Invalid choice");
        } else if (indexOrArtist == 0) {
            System.out.println("Enter Index number:");
            index = input.nextInt();
            if (!playlist.containsKey(index)) {
                System.out.println("No entries");
                search(input);
            } else {
                System.out.println("Found entry: " + index + " " + playlist.get(index));
                menu();
            }
        } else {
            System.out.println("Enter Artist name:");
            artist = input.next();
            if (!playlist.containsValue(artist)) {
                System.out.println("No entries");
                search(input);
            } else {
                System.out.println("Found entry: " + artist);
                menu();
            }
        }
    }

    static void edit(Scanner input){
        System.out.println("------ EDIT ------");
        for (int i : playlist.keySet()) {
            System.out.println(i + " " + playlist.get(i));
        }
        System.out.println("Enter Index to edit:");
        int indexEdit = input.nextInt();
        if(!playlist.containsKey(indexEdit)){
            System.out.println("Index not found");
            edit(input);
        } else {
            System.out.println("Selected: " + playlist.get(indexEdit) + " " + "");
            System.out.println("Enter new Artist name:");
            String newArtist = input.next();
            System.out.println("New details: " + indexEdit + " " + newArtist);
            playlist.replace(indexEdit, newArtist);
            menu();
        }
    }

    static void delete(Scanner input) {
        System.out.println("------ DELETE ------");
        for (int i : playlist.keySet()) {
            System.out.println(i + " " + playlist.get(i));
        }
        System.out.println("Delete by Index press 0 or Artist press 1");
        int indexOrArtist = input.nextInt();
        if (indexOrArtist != 0 && indexOrArtist != 1) {
            System.out.println("Invalid choice");
            delete(input);
        } else if (indexOrArtist == 0) {
            System.out.println("Index number:");        // index
            int index = input.nextInt();
            if (!playlist.containsKey(index)) {
                System.out.println("No entries for this index");
                delete(input);
            } else {
                System.out.println("Entry deleted: " + index);
                playlist.remove(index);
                menu();
            }
        } else {
            System.out.println("Artist name:");     // artist
            String artist = input.next();
            if (!playlist.containsValue(artist)) {
                System.out.println("No entries for this artist");
                delete(input);
            } else {
                System.out.println("Entry deleted: " + artist);
                playlist.remove(artist);
                menu();
            }
        }
    }
}