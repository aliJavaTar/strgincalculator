import java.util.*;
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

    private String[] findBetweenBracket() {
        String regex = "\\[(.*?)]";
        String group = findByRegex(regex, 1);
        String[] findWords = group.split(",");
        sortByLength(findWords);
        return findWords;
    }

    //    protected String splitText() {
//        String finalText = "";
//        for (String f : find) {
//            String[] split = this.inputText.split(f);
//            finalText = Arrays.toString(split);
//        }
//        System.out.println(finalText);
//        return finalText;
//    }
    protected void splitText() {
        String[] find = findBetweenBracket();
        StringBuilder add = new StringBuilder();
        for (String f : find) {
            if (TextHavaNumber(f)) {
                boolean contains = inputText.contains("\n" + f);
                f = replaceCustomSeparator(f);

                String[] split = inputText.split(f);
                if (contains) {
                    add.append(findByRegex("\n" + f, 0));
                }
                inputText = Arrays.toString(split) + add;
            }

        }

    }


    private boolean TextHavaNumber(String wordFind) {
        boolean containsNumber = false;
        String[] arrayWordFind = convertToArray(wordFind);
        for (int index = 0; index < wordFind.length(); index++) {
            if (isValidation(arrayWordFind[index]))
                containsNumber = true;
        }
        return containsNumber;
    }

    private boolean isValidation(String value) {
        String regex = "[0-9]+";
        return Pattern.matches(regex, value);
    }

    private void sortByLength(String[] findWords) {
        Arrays.sort(findWords, Comparator.comparingInt(String::length).reversed());
    }

    private String replaceCustomSeparator(String separator) {
        String[] separatorArray = convertToArray(separator);
        for (int index = 0; index < separatorArray.length; index++) {
            if (isSpecialChar(separatorArray[index])) {
                separatorArray[index] = "\\" + separatorArray[index];
            }
        }
        return Arrays.toString(separatorArray);
    }

    private boolean isSpecialChar(String value) {
        String regex = "[^A-Za-z0-9]";
        return Pattern.matches(regex, value);
    }

    String[] convertToArray(String array) {
        return array.split("");
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
