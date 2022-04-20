import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        else {
            String correction = textCorrection(numbers);
            return sumNumbers(correction);
        }
    }

    private int sumNumbers(String string) {
        int sum = 0;
        String[] array = convertToArray(string);
        String sumNumber = "";

        for (String s : array) {
            if (validation(s)) {
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


    private String textCorrection(String sentence)
    {
        String[] arrayText = sentence.split("");
        int index1, index2;
        if (haveBrokeOpenAndClose(arrayText))
        {
            index1 = sentence.indexOf("[");
            index2 = sentence.indexOf("]");
            String find = findWord(index1, index2, sentence);
            if (!find.isEmpty())
                return replace(sentence, find);
            else return sentence;
        } else return sentence;
    }

    private String replace(String text, String find) {
        if (text.contains(find) && havaNumber(find))
            return text.replaceAll("[^\\n]" + find, "");
        else return text;
    }

    private boolean havaNumber(String wordFind) {
        boolean containsNumber = false;
        String[] arrayWordFind = wordFind.split("");
        for (int index = 0; index < wordFind.length(); index++) {
            if (validation(arrayWordFind[index]))
                containsNumber = true;
        }
        return containsNumber;
    }

    private String findWord(int index1, int index2, String test) {
        String[] split = test.split("");
        String word = "";
        for (int index = index1 + 1; index < index2; index++) {
            word += split[index];
        }
        return word;
    }

    private boolean haveBrokeOpenAndClose(String[] array) {
        boolean haveBroke = false;
        for (int index = 0; index < array.length; index++)
        {
            if (array[index].contains("["))
            {
                for (int i = index; i < array.length; i++)
                {
                    if (array[i].contains("]"))
                    {
                        haveBroke = true;
                        break;
                    }
                }
                break;
            }
        }
        return haveBroke;
    }

    private String[] convertToArray(String array) {
        return array.split("");
    }

    private int convertToInteger(String number) {
        return Integer.parseInt(number);
    }

    private boolean validation(String value) {
        String regex = "[0-9]+";
        return Pattern.matches(regex, value);
    }
}