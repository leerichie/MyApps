package startup.game;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameHelper {
    private static final String Alphabet = "abcdefg";
    private static final int Grid_Length = 7;
    private static final int Grid_Size = 49;
    private static final int Max_Attempts = 200;
    static final int Horizontal_Increment = 1;
    static final int Vertical_Increment =  Grid_Length;

    private final int[] grid = new int[Grid_Size];
    private final Random random = new Random();
    private int startupCount;

    public String getUserInput(String prompt){
        System.out.println(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    public ArrayList<String> placeStartup(int startupSize){
        int[] startupCoords = new int[startupSize];
        int attempts = 0;
        boolean success = false;

        startupCount++;
        int increment = getIncrement();

        while (!success & attempts++ < Max_Attempts){
            int location = random.nextInt(Grid_Size);

            for (int i=0; i<startupCoords.length; i++){
                startupCoords[i] = location;
                location += increment;
            }

            if (startupFits(startupCoords, increment)){
                success = coordsAvailable(startupCoords);
            }
        }
        savePositionToGrid(startupCoords);
        ArrayList<String> alphaCells = convertCoordsToAlphaFormat(startupCoords);
        return alphaCells;
    }

    private boolean startupFits(int[] startupCoords, int increment){
        int finalLocation = startupCoords[startupCoords.length -1];
        if (increment == Horizontal_Increment){
            return calcRowFromIndex(startupCoords[0]) == calcRowFromIndex(finalLocation);
        } else {
            return finalLocation < Grid_Size;
        }
    }
    private boolean coordsAvailable(int[] startupCoords){
        for (int coord : startupCoords){
            if (grid[coord] != 0){
                return false;
            }
        }
        return true;
    }
    private void savePositionToGrid(int[] startupCoords){
        for (int index : startupCoords){
            grid[index] = 1;
        }
    }
    private ArrayList<String> convertCoordsToAlphaFormat(int[] startupCoords){
        ArrayList<String> alphaCells = new ArrayList<String>();
        for (int index : startupCoords){
            String alphaCoords = getAlphaCoordsFromIndex(index);
            alphaCells.add(alphaCoords);
        }
        return alphaCells;
    }
    private String getAlphaCoordsFromIndex(int index){
        int row = calcRowFromIndex(index);
        int column = index % Grid_Length;
        String letter = Alphabet.substring(column, column +1);
        return letter + row;
    }
    private int calcRowFromIndex(int index){
        return index / Grid_Length;
    }
    private int getIncrement(){
        if (startupCount % 2 == 0){
            return Horizontal_Increment;
        } else {
            return Vertical_Increment;
        }
    }
}
