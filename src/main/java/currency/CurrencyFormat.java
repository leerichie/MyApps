package currency;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormat {
    public static void main(String[] args) {

//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter amount: ");
//        double amount = input.nextDouble();
        double amount = 1542.50;

        // Create NumberFormat instances for different locales
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        // Format the amount using NumberFormat
        String formattedPaymentUS = usFormat.format(amount);
        String formattedPaymentIndia = indiaFormat.format(amount);
        String formattedPaymentChina = chinaFormat.format(amount);
        String formattedPaymentFrance = franceFormat.format(amount);

        // Print the formatted values
        System.out.printf("%-10s %-15s\n", "Country", "Currency");
        System.out.println("---------------------");
        System.out.printf("%-10s %-15s\n", "US: ", formattedPaymentUS);
        System.out.printf("%-10s %-15s\n", "India: ", formattedPaymentIndia);
        System.out.printf("%-10s %-15s\n", "China: ", formattedPaymentChina);
        System.out.printf("%-10s %-15s\n", "France: ", formattedPaymentFrance);
    }
}
