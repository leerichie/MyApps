package calculator;

import java.util.Scanner;

public class CalcMenu {
    CalcLogic calcLogic = new CalcLogic();
    Scanner input = new Scanner(System.in);

    public void display() {

        int choiceFromMenu;

        do {
            System.out.println("*----- Calculator v1 -----*");
            System.out.println("1 - Add");
            System.out.println("2 - Subtract");
            System.out.println("3 - Multiply");
            System.out.println("4 - Divide");
            System.out.println("5 - Calculator v2 -> NEW");
            System.out.println("0 - Exit ");
            System.out.println("  What do you want to do?");
            System.out.println("*-------------------------*");
            choiceFromMenu = input.nextInt();

            // calculation inputs
            switch (choiceFromMenu) {
                case 1 -> {
                    System.out.println("*----- ADD -----*\n" +
                            "Enter first number:");
                    int num1 = input.nextInt();
                    System.out.println("Enter second number:");
                    int num2 = input.nextInt();
                    System.out.println("Result:");
                    System.out.println(calcLogic.add(num1, num2));
                }
                case 2 -> {
                    System.out.println("*----- SUBTRACT -----*\n" +
                            "Enter first number:");
                    int num1 = input.nextInt();
                    System.out.println("Enter second number:");
                    int num2 = input.nextInt();
                    System.out.println("Result:");
                    System.out.println(calcLogic.subtract(num1, num2));
                }
                case 3 -> {
                    System.out.println("*----- MULTIPLY -----*\n" +
                            "Enter first number:");
                    int num1 = input.nextInt();
                    System.out.println("Enter second number:");
                    int num2 = input.nextInt();
                    System.out.println("Result:");
                    System.out.println(calcLogic.multiply(num1, num2));
                }
                case 4 -> {
                    System.out.println("*----- DIVIDE -----*\n" +
                            "Enter first number:");
                    int num1 = input.nextInt();
                    System.out.println("Enter second number:");
                    int num2 = input.nextInt();
                    System.out.println("Result:");
                    System.out.println(calcLogic.divide(num1, num2));
                }
                case 5 -> {
                    System.out.println("*---- Calculator v2 ----*");
                    System.out.println("Enter first number:");
                    int num1 = input.nextInt();

                    System.out.println("What would you like to do:\n"
                            + "+   -   *   /");
                    String symbol = input.next();

                    System.out.println("Enter second number:");
                    int num2 = input.nextInt();

                    System.out.println("Result:");
                    double result = 0;

                    switch (symbol.charAt(0)){
                        case '+' -> result = num1 + num2;
                        case '-' -> result = num1 - num2;
                        case '*' -> result = num1 * num2;
                        case '/' -> result = num1 / num2;
                    }
                    System.out.println(num1 + " " + symbol.charAt(0) + " " + num2 + " = " + result + "\n");
                }
            }
            if (choiceFromMenu > 5){
                System.out.println("Invalid choice\n");
            }
        }
        while (choiceFromMenu != 0);
        System.out.println("Goodbye! ");
    }
}