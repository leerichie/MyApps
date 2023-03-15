package todo.list;

import java.util.Scanner;

public class ToDoMenu {

    private final String[] menuName = new String[4];
    private int menuNum;
    private ToDoStorage toDoStorage = new ToDoStorage();


    public ToDoMenu() {
        menuName[0] = "0 - Exit";
        menuName[1] = "1 - Add note";
        menuName[2] = "2 - Delete note";
        menuName[3] = "3 - Show notes";

        do {
            System.out.println("---- ToDo ----");
            System.out.println("1 - Add note");
            System.out.println("2 - Delete note");
            System.out.println("3 - Show notes");
            System.out.println("0 - Exit");
            System.out.println("---------------");
        }
        while (menuNum != 0);

        Scanner input = new Scanner(System.in);
        menuNum = input.nextInt();

        switch (menuNum) {
            case 1 -> toDoStorage.addNote(input);
            case 2 -> toDoStorage.deleteNote(input);
            case 3 -> toDoStorage.showNotes(input);
        }

    }
}
