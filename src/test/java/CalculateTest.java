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
    void enterTwoNumber()
    {
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

//    @Test
//    void enterSingleString() {
//
//        int add;
//        add = calculate.add(text);
//        assertEquals(add, 1);
//
//        add = calculate.add("22");
//        assertEquals(add, 22);
//
//        add = calculate.add("333");
//        assertEquals(add, 333);
//    }

}