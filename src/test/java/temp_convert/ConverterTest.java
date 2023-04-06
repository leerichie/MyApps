package temp_convert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    public void testFahrenheitToCelsius() {
        int fahren = 32;
        int expected = 0;
        int actual = Converter.fahrenheitToCelsius(fahren);
        assertEquals(expected, actual);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        int cels = 0;
        int expected = 32;
        int actual = Converter.celsiusToFahrenheit(cels);
        assertEquals(expected, actual);
    }
}