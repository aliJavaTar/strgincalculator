import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.Arrays.*;
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

    @Test
    public void enterNumbers() {
        int add = calculator.add("1,2,3,4");
        assertEquals(10, add);
        int add1 = calculator.add("2,2,2,2,2,2,2,2");
        assertEquals(16, add1);
        int add2 = calculator.add("5,2,7");
        assertEquals(14, add2);
    }

    @Test
    public void enterNumberWhitCharacter() {
        int add = calculator.add("1\n2,3");
        assertEquals(6, add);

        int add1 = calculator.add("//;\n1;2");
        assertEquals(3, add1);

        int add2 = calculator.add("//[*][%]\n1*2%3");
        assertEquals(6, add2);

        int add3 = calculator.add("//[***]\n1***2***3");
        assertEquals(6, add3);

        int add4 = calculator.add("//[foo][bar3]\n1foo2bar3");
        assertEquals(3, add4);

        int add5 = calculator.add("//[e];\n1;2");
        assertEquals(3, add5);

    }

    @Test
    public void separatorsWithoutExit() {
        int add = calculator.add("//[e];\n1;2");
        assertEquals(3, add);
        int add1 = calculator.add("//[w];\n1;2,5");
        assertEquals(8, add1);
        int add2 = calculator.add("//[o];\n1");
        assertEquals(1, add2);
        int add3 = calculator.add("//[o][%]\n1*2%3");
        assertEquals(6, add3);
    }

    @Test
    public void numberOneBetweenCharacters() {

        int add1 = calculator.add("//[1_€#@546]\n1*1_€#@546*2*1_€#@546*3");
        assertEquals(6, add1);

        int add2 = calculator.add("//[1_€#@]\n1#1_€#@*2*1_€#@*3");
        assertEquals(6, add2);
    }

    @Test
    public void setCalculatorTest() {
        int add = calculator.add("2,22");
        assertEquals(24, add);

        int add1 = calculator.add("22,22");
        assertEquals(44, add1);

        int add2 = calculator.add("2,11,2");
        assertEquals(15, add2);
    }

    @Test
    public void NumberBiggerThan1000() {
        int add = calculator.add("1001,2");
        assertEquals(2, add);
        int add1 = calculator.add("5000,88");
        assertEquals(88, add1);
        int add2 = calculator.add("2221,7,7");
        assertEquals(14, add2);
    }

    @Test
    public void beforeSeparatorsNewLine() {
        int add = calculator.add("[1]\n1*2*1*3*1");
        assertEquals(6, add);
        int add1 =calculator.add("[23]\n23*1*3,23");
        assertEquals(27, add1);
    }

    @Test
    public void testIdea() {
        int add = calculator.add("//[foo][foo23bar][bar]\n1foo23bar3");
        assertEquals(4, add);
    }
}