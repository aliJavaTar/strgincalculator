import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TextTest {
    private Text text;

    @BeforeEach
    private void createObject() {
        text = new Text();
    }

    @Test
    void splitNumbers() {
        String[] numbers;
        text.setInputText("1,2");
        numbers = new String[]{"1", "2"};
        assertArrayEquals(numbers, text.splitNumbers());

        text.setInputText("12vcb4");
        numbers = new String[]{"12", "4"};
        assertArrayEquals(numbers, text.splitNumbers());

        text.setInputText("1vb6**87");
        numbers = new String[]{"1", "6", "87"};
        assertArrayEquals(numbers, text.splitNumbers());
    }


    @Test
    void isEmpty() {
        text.setInputText("");
        assertTrue(text.isEmpty());
    }
}