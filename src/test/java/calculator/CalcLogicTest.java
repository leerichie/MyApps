package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalcLogicTest {

    @Test
    void addition() {
        int resultA = 2 + 2;
        assertEquals(4, resultA);
    }

    @Test
    void subtract() {
        int resultS = 10 - 5;
        assertEquals(5, resultS);
    }

    @Test
    void multiply() {
        int resultM = 4 * 6;
        assertEquals(24, resultM);
    }

    @Test
    void divide() {
        int resultD = 100 / 10;
        assertEquals(10, resultD);
    }
    @Test
    void divideByZero(){
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            CalcLogic calcLogic = new CalcLogic();
            calcLogic.divide(10, 0);
        });

        String expectedMessage = "/ by zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}