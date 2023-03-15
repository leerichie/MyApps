package calculator;

import java.util.Scanner;

public class CalcAppTwo {
    public static void main(String[] args) {
        calcTwo();
    }

    public static void calcTwo() {
        Scanner in = new Scanner(System.in);

        System.out.println("*---- Calculator v2 ----*");
        System.out.println("Enter first number:");
        int num1 = in.nextInt();

        System.out.println("What would you like to do:\n"
                + "+   -   *   /");
        String symbol = in.next();

        System.out.println("Enter second number:");
        int num2 = in.nextInt();

        System.out.println("Result:");
        double result = 0;

        switch (symbol.charAt(0)){
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
        }
        System.out.println(num1 + " " + symbol.charAt(0) + " " + num2 + " = " + result);
    }
}
