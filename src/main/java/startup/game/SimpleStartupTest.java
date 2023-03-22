//package startup.game;
//
//import java.util.Scanner;
//
//public class SimpleStartupTest {
//    public static void main(String[] args) {
//
//        SimpleStartup dot = new SimpleStartup();
//
////        Scanner scanner = new Scanner(System.in);
//
//        // MATH RANDOM for setting locations
////        int randomNum = (int) (Math.random() * 5);
////        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
////        dot.setLocationCells(locations);
//
//        // SCANNER for setting locations
////        int[] locations = new int[3];
////        for(int i=0; i<locations.length; i++){
////            System.out.println("Enter location " + (i + 1) + ": ");
////            locations[i] = scanner.nextInt();
////            dot.setLocationCells(locations);
////        }
//
////         pre-set locations
//        int[] locations = {2,3,4};
//        dot.setLocationCells(locations);
//
//
//        int userGuess = 3;
////        System.out.println("Your guess: ");
////        int userGuess = scanner.nextInt();
//
//        String result = dot.checkYourself(userGuess);
//
//        String testResult = "failed";
//        if (result.equals("Hit!")) {
//            testResult = "passed";
//        }
//
//        System.out.println(testResult);
//    }
//}