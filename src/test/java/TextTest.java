import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void negativesNotAllowedTest() {
        text.setInputText("1,-2,-3");
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    text.negativesNotAllowed();
                }).withMessageContaining("error: negatives not allowed -2,-3");

        text.setInputText("1,2,-3");
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    text.negativesNotAllowed();
                }).withMessageContaining("error: negatives not allowed -3");

        text.setInputText("-1,6,-8");
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> {
                    text.negativesNotAllowed();
                }).withMessageContaining("error: negatives not allowed -1,-8");
    }
}
