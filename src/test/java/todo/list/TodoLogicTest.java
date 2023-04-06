package todo.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoLogicTest {

    private TodoLogic todoLogic;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        todoLogic = new TodoLogic();
        scanner = mock(Scanner.class);
    }

    @Test
    void testTodoLogic() {
        String input = "name\nDo laundry\n05/04/2023\ny\n09:00 AM\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        when(scanner.nextLine()).thenReturn("name", "Do laundry", "05/04/2023", "y", "09:00 AM");

        LocalDate locDate = LocalDate.now();
        String d = locDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalTime locTime = LocalTime.now();
        String t = locTime.format(DateTimeFormatter.ofPattern("h:mm a"));

        LocalDateTime locDateTime = LocalDateTime.now();
        String dt = locDateTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm"));

        String[] dateTime = {"Do laundry", "05/04/2023", "09:00 AM"};

        String expectedOutput = "Correct! ...welcome name\n\n"
                + "*------- ToDo -------*\n"
                + "What's the reminder for:\n"
                + "Today is " + d + "\n"
                + "On what date: (d/m/y)\n"
                + "Would you like to add an alarm? (y/n)\n"
                + "The time now is " + t + "\n"
                + "When do you want the alarm for: (hh:mm am/pm)\n"
                + "Your reminder 'Do laundry' on '05/04/2023' at '09:00 AM' has been saved! \n- Goodbye!\n\n\n";


    }

}
