import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    protected void negativesNotAllowed() throws Exception {
        String regex = "-\\d+";
        String group = findByRegex(regex, 0);
        if (!group.isEmpty())
            throw new Exception("error: negatives not allowed " + group);
    }

    private String findByRegex(String regex, int number) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);
        String group = "";
        while (matcher.find()) {
            group += matcher.group(number) + ",";
        }
        return group;
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
