package todo.list;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ToDoStorage {
    private ToDoItems[] listOfOptions;
    private int numOfItems;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private Date d = new Date();

    public ToDoStorage() {
        listOfOptions = new ToDoItems[3];
    }

    public void addNote(Scanner input) {
        System.out.println("Set priority (1-10):");
        int priority = input.nextInt();
        System.out.println("What's the note?");
        String noteName = input.next();
        System.out.println("Set date for completion (dd-MM-yyyy):");
        String date = input.nextLine();
        date = sdf.format(d);
        input.nextLine();
//        try{
//            d = sdf.parse(date);
//        } catch (Exception e) {
//            System.out.println("Invalid date format.");
//        }
        if(priority < 0 || priority >= listOfOptions.length){
            System.out.println("Invalid option");
        } else if (listOfOptions[priority] != null) {
            System.out.println("Index priority taken");
        } else {
            listOfOptions[priority] = new ToDoItems(priority, noteName, false, d);
            System.out.println("Added successfully: " + priority + ": " + noteName + "\nDue by: " + d);
            numOfItems++;
        }
        ToDoMenu toDoMenu = new ToDoMenu();
        System.out.println(toDoMenu);

    }
    public void deleteNote(Scanner input){
        System.out.println("Choose a note to delete:");
        for (ToDoItems list : listOfOptions) {
            System.out.println(list.getPriority() + " " + list.getDescription() + " " + list.getDate());
        }
        int choice = input.nextInt();
        if(listOfOptions[choice] != null){
            listOfOptions[choice] = null;
            System.out.println("Deleted! \n"
                    + listOfOptions[choice].getPriority() + "\n "
                    + listOfOptions[choice].getDescription() + "\n "
                    + listOfOptions[choice].getDate());
            numOfItems--;
        } else {
            System.out.println("No notes for your chosen number!");
        }
        ToDoMenu toDoMenu = new ToDoMenu();
        System.out.println(toDoMenu);
    }
    public void showNotes(Scanner input){
        System.out.println("---- NOTES ----");
        for (ToDoItems list : listOfOptions) {
            System.out.println(list.getPriority() + " " + list.getDescription() + " " + list.getDate());
        }
        System.out.println("----------------");

        ToDoMenu menu = new ToDoMenu();
        System.out.println(menu);
    }
}
