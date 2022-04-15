import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    private void createObject() {
        calculator = new StringCalculator();
    }

    @Test
    public void enterEmpty() {
        int add = calculator.add("");
        assertEquals(0, add);
    }

    @Test
    public void oneNumber() {
        int add = calculator.add("1");
        assertEquals(1, add);
        int add1 = calculator.add("3");
        assertEquals(3, add1);
        int add2 = calculator.add("7");
        assertEquals(7, add2);
    }

    @Test
    public void twoNumber() {

        int add = calculator.add("1,2");
        assertEquals(3, add);
        int add1 = calculator.add("2,2");
        assertEquals(4, add1);
        int add2 = calculator.add("5,2");
        assertEquals(7, add2);
    }
}