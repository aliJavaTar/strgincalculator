import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Text {
    private String inputText;

    public Text() {
    }

    protected String[] splitNumbers() {
        List<String> numbersList = new ArrayList<>();
        String[] splits = inputText.split("\\D");

        for (String n : splits) {
            if (!n.isEmpty())
                numbersList.add(n);
        }
       return numbersList.toArray(new String[0]);
    }

    public Text(String inputText) {
        this.inputText = inputText;
    }

    protected boolean isEmpty() {
        return inputText.isEmpty();
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
}
