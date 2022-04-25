import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers)
    {
        if (numbers.isEmpty()) return 0;
        String[] betweenBracket = findBetweenBracket(numbers);
        String replace = replace(numbers, betweenBracket);
        return sumNumbers(replace);
    }

    private int sumNumbers(String string)
    {
        String trim = string.trim();
        int sum = 0;
        String[] array = convertToArray(trim);
        String sumNumber = "";
        for (String s : array)
        {
            if (isValidation(s))
            {
                sumNumber = sumNumber + s;
                if (sumNumber.length() > 3)
                    sumNumber = "";
            } else {
                if (!sumNumber.isEmpty() && !sumNumber.isBlank())
                    sum += convertToInteger(sumNumber);
                sumNumber = "";
            }
        }
        return sum + convertToInteger(sumNumber);
    }

    private String replace(String text, String[] find) {

        for (String f : find)
        {
            if (havaNumber(f))
            {
                boolean contains = text.contains("\n" + f);
                String[] split = text.split(f);
                if (contains)
                    split[0] += f;

                text = Arrays.toString(split);
            }
        }
        return text;
    }

    private boolean havaNumber(String wordFind)
    {
        boolean containsNumber = false;
        String[] arrayWordFind = convertToArray(wordFind);
        for (int index = 0; index < wordFind.length(); index++) {
            if (isValidation(arrayWordFind[index]))
                containsNumber = true;
        }
        return containsNumber;
    }

    private String[] convertToArray(String array) {
        return array.split("");
    }

    private int convertToInteger(String number) {
        if (!number.isEmpty())
            return Integer.parseInt(number);
        return 0;
    }

    private boolean isValidation(String value) {
        String regex = "[0-9]+";
        return Pattern.matches(regex, value);
    }

    private String[] findBetweenBracket(String sentences) {
        Pattern pattern = Pattern.compile("\\[(.*?)]");
        Matcher matcher = pattern.matcher(sentences);
        String group = "";
        while (matcher.find()) {
            group += matcher.group(1) + ",";
        }
        System.out.println("group: "+ group);
        String[] findWords = group.split(",");
        System.out.println("array group: "+Arrays.toString(findWords));
        Arrays.sort(findWords, Comparator.comparingInt(String::length).reversed());
        return findWords;
    }
}