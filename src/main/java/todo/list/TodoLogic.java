package todo.list;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TodoLogic {

    TodoLogic() {
        LocalDate locDate = LocalDate.now();
        String d = locDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        System.out.println(d);

        LocalDateTime locDateTime = LocalDateTime.now();
        String dt = locDateTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm"));
//        System.out.println(dt);

        LocalTime locTime = LocalTime.now();
        String t = locTime.format(DateTimeFormatter.ofPattern("h:mm a"));
//        System.out.println(t);

//        System.out.println(" ");

        //  schedule
        String[] dateTime = new String[3];

        Scanner in = new Scanner(System.in);
        System.out.println("\n ->  Hi there, enter your name to continue:  <-");
        String name = in.nextLine();
        if (name.equals("name") || name.equals("name1") || name.equals("name2")) {
            System.out.println("Correct! ...welcome " + name + "\n");
            System.out.println("*------- ToDo -------*");
            System.out.println("What's the reminder for:");
            dateTime[0] = in.nextLine();
            System.out.println("Today is " + d);
            System.out.println("On what date: (d/m/y)");
            dateTime[1] = in.nextLine();
            System.out.println("Would you like to add an alarm? (y/n)");
            String yesNo = in.nextLine();
            if (yesNo.charAt(0) == 'y' || yesNo.equals("yes")
                    || yesNo.charAt(0) == 'Y' || yesNo.equals("Yes") || yesNo.equals("YES")) {
                System.out.println("The time now is " + t);
                System.out.println("When do you want the alarm for: (hh:mm am/pm)");
                dateTime[2] = in.nextLine();
                System.out.println("Your reminder '" + dateTime[0]
                        + "' on '" + dateTime[1]
                        + "' at '" + dateTime[2]
                        + "' has been saved! \n- Goodbye!\n\n\n");
            } else {
                System.out.println("Your reminder '" + dateTime[0]
                        + "' on '" + dateTime[1]
                        + "' has been saved!" +
                        " - No Alarm!");
            }
        } else {
            System.out.println("You're not known :( \n - Goodbye!\n\n\n");


//        System.out.println("Reminder saved!");
//        for(String s : dateTime){
//            System.out.println(s);
//        }
        }
    }
}