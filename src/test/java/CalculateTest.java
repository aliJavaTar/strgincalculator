import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ItemEvent;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {
    private Calculate calculate;

    @BeforeEach
    private void createObject() {
        calculate = new Calculate();

    }

    @Test
    void enterEmptyString() {
        int add;
        calculate.setInputText("");
        add = calculate.add();
        assertEquals(add, 0);
    }

    @Test
    void enterSingleNumber() {
        int add;

        calculate.setInputText("1");
        add = calculate.add();
        assertEquals(add, 1);

        calculate.setInputText("22");
        add = calculate.add();
        assertEquals(add, 22);

        calculate.setInputText("333");
        add = calculate.add();
        assertEquals(add, 333);
    }

    @Test
    void enterTwoNumber() {
        int add;

        calculate.setInputText("1,1");
        add = calculate.add();
        assertEquals(add, 2);

        calculate.setInputText("5,2");
        add = calculate.add();
        assertEquals(add, 7);

        calculate.setInputText("33,4");
        add = calculate.add();
        assertEquals(add, 37);
    }

    @Test
    void enterMultiNumbers() {
        int add;

        calculate.setInputText("1,2,3,4,5,6,7,8,9");
        add = calculate.add();
        assertEquals(add, 45);

        calculate.setInputText("5,2,7,8");
        add = calculate.add();
        assertEquals(add, 22);

        calculate.setInputText("33,4,78");
        add = calculate.add();
        assertEquals(add, 115);
    }

    @Test
    void enterNewLineSeparator() {
        int add;

        calculate.setInputText("1\n2,3");
        add = calculate.add();
        assertEquals(add, 6);

        calculate.setInputText("5\n2,\n7,8");
        add = calculate.add();
        assertEquals(add, 22);

        calculate.setInputText(",\n33,4,78");
        add = calculate.add();
        assertEquals(add, 115);
    }

    @Test
    void enterCustomSeparators() {
        int add;

        calculate.setInputText("//;\n1;2");
        add = calculate.add();
        assertEquals(add, 3);

        calculate.setInputText("5\n2,\n7,////8");
        add = calculate.add();
        assertEquals(add, 22);

        calculate.setInputText(",\n33,4,*&^%$78");
        add = calculate.add();
        assertEquals(add, 115);
    }

    @Test
    void disallowNegatives()
    {
        int add;

        calculate.setInputText("-2");
        add = calculate.add();
        assertEquals(add, -1);

        calculate.setInputText("5\n2,\n7,////-8");
        add = calculate.add();
        assertEquals(add, -1);

        calculate.setInputText(",\n-33,4,*&^%$78");
        add = calculate.add();
        assertEquals(add, -1);

    }

    @Test
    void ignoreNumbersBiggerThan1000()
    {
        int add;

        calculate.setInputText("1001,2");
        add = calculate.add();
        assertEquals(add, 2);

        calculate.setInputText("10001,3,4");
        add = calculate.add();
        assertEquals(add, 7);

        calculate.setInputText("1,20000,6");
        add = calculate.add();
        assertEquals(add, 7);
    }
    @Test
    void multiLengthSeparators()
    {
        int add;

        calculate.setInputText("//[*9*]\n1***2***3");
        add = calculate.add();
        assertEquals(add, 6);

        calculate.setInputText("//[1]\n1**2*\n1*3");
        add = calculate.add();
        assertEquals(add, 7);

        calculate.setInputText("//[3]\n1***2***3");
        add = calculate.add();
        assertEquals(add, 3);

        calculate.setInputText("//[*][%]\n123");
        add = calculate.add();
        assertEquals(add, 123);

        calculate.setInputText("//[1][%]\n2,4");
        add = calculate.add();
        assertEquals(add, 6);

        calculate.setInputText("//[12][%]\n12,22");
        add = calculate.add();
        assertEquals(add, 34);

    }
    @Test
    public void testIdea() {
        int add;
        calculate.setInputText("//[foo][foo23bar][bar]\n1foo23bar3");
        add = calculate.add();
        assertEquals(4, add);

        calculate.setInputText("//[foo2][foo23bar][bar]\n1foo23bar3");
        add = calculate.add();
        assertEquals(4, add);

        calculate.setInputText("//[foo2][foo23bar][bar3]\n1foo23bar3");
        add = calculate.add();
        assertEquals(4, add);
    }

}
