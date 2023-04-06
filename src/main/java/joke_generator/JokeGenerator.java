package joke_generator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JokeGenerator {
    public static void main(String[] args) {
        String[] jokesEN = {
                "Why did the tomato turn red? Because it saw the salad dressing!",
                "What do you call a fake noodle? An impasta!",
                "Why don't scientists trust atoms? Because they make up everything!",
                "Why did the chicken cross the playground? To get to the other slide!",
                "Why was the math book sad? Because it had too many problems.",
                "Why do seagulls fly over the sea? Because if they flew over the bay, they'd be bagels!",
                "Why don't eggs tell jokes? Because they'd crack each other up!",
                "What do you call a bear with no teeth? A gummy bear!"
        };

        String[] jokesPl = {
                "Antek radzi się agronoma:\n" +
                        "- Mówią, że nawóz sztuczny jest lepszy od naturalnego. A pan jak uważa?\n" +
                        "- Trudno powiedzieć, to rzecz smaku.",
                "Spotykają się dwie pchły:\n" +
                        "- Gdzie spędziłaś wakacje?\n" +
                        "- Na krecie.",
                "Idzie sobie żółw, spotyka drugiego bez pancerza. Pyta:\n" +
                        "- Co Ci się stało?\n" +
                        "- Aaa... uciekłem z domu.",
                "Siedzi krowa na wierzbie. Podchodzi do niej osioł i pyta:\n" +
                        "- Krowa co Ty robisz tam na tej wierzbie?\n" +
                        "- Jem śliwki.\n" +
                        "- No ale to przecież wierzba, to jak możesz jeść na niej śliwki kiedy na niej one nie rosną?\n" +
                        "- A śliwki to ja mam w torebce."
        };

        List<User> users = Arrays.asList(
                new User("Serwi", "serwi123"),
                new User("Sarah", "letmein"),
                new User("Mike", "qwerty"),
                new User("Emily", "123456"),
                new User("Bob", "monkey")
        );

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int index;
        String userInput = "";
        boolean isProgrammer = false;

        System.out.println("Welcome to the joke generator!");
        System.out.println("Please enter your name:");

        // check username
        String inputName = scanner.nextLine();

        User currentUser = users.stream()
                .filter(user -> user.getName().equals(inputName))
                .findFirst()
                .orElse(null);

        // check password match
        if (currentUser != null) {
            System.out.println("Hello " + currentUser.getName() + ", please enter your password to access the programmer mode:");
            String inputPassword = scanner.nextLine();

            if (currentUser.getPassword().equals(inputPassword)) {
                isProgrammer = true;
                System.out.println("Programmer mode activated!");
            } else {
                System.out.println("Incorrect password. Access denied.");
                scanner.close();
                return;
            }
        } else {
            System.out.println("User not found. Access denied.");
            scanner.close();
            return;
        }

        while (!userInput.equals("0")) {
            System.out.println("Press any key to generate a random joke or press 0 to exit");
            userInput = scanner.nextLine();

            if (userInput.equals("0")) {
                System.out.println("Goodbye :)");
            } else {
                System.out.println("Choose language / Wybierz jezyk:");
                System.out.println("1 - English");
                System.out.println("2 - Polski");
                int lang = scanner.nextInt();
                if (lang == 1){
                    System.out.println("\nGenerating joke...");
                    index = rand.nextInt(jokesEN.length);
                    System.out.println(jokesEN[index]);
                } else if (lang == 2){
                    System.out.println("\nGenerating joke...");
                    index = rand.nextInt(jokesPl.length);
                    System.out.println(jokesPl[index]);
                } else {
                    System.out.println("\nInvalid choice / Blad!");
                }
            }
        }
        scanner.close();
    }
}

class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
