import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
            String[] betweenBracket = findBetweenBracket(numbers);
            String replace = replace(numbers, betweenBracket);
            return sumNumbers(replace);
    }

    private int sumNumbers(String string) {
        int sum = 0;
        String[] array = convertToArray(string);
        String sumNumber = "";
        for (String s : array)
        {
            if (validation(s))
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
        int x = text.lastIndexOf(']');
        String test="";
        for (int index = x+1; index < text.length(); index++)
        {
            test+=text.charAt(index);
        }
        System.out.println("test "+test );

            for (String f : find)
            {
                if (test.contains(f) && havaNumber(f) )
                {
                    //[^\\n]
                    String[] split = test.split(f);
                    test = Arrays.toString(split);
                }
            }

        return test;
    }

    private boolean havaNumber(String wordFind) {
        boolean containsNumber = false;
        String[] arrayWordFind = convertToArray(wordFind);
        for (int index = 0; index < wordFind.length(); index++) {
            if (validation(arrayWordFind[index]))
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

    private boolean validation(String value) {
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

        String[] findWords = group.split(",");

        Arrays.sort(findWords, Comparator.comparingInt(String::length).reversed());
        return findWords;
    }
}

