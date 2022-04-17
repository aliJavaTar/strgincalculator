import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        else
            return sumNumbers(textCorrection(numbers));
    }

    private int sumNumbers(String string) {
        int sum = 0;
        String[] array = convertToArray(string);
        String sumNumber = "";

        for (int index = 0; index < array.length; index++) {
            if (validation(array[index])) {
                if (index > 1) {
                    if (isTrue(array, index))
                        array[index] = "0";

                }

                sumNumber = sumNumber + array[index];
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

    private boolean isTrue(String[] array, int index) {
        return array[index].equals("1") &&
                (validationStar(array[index - 1]) && validationStar(array[index + 1])) &&
                (!array[index - 1].equals(",") && !array[index + 1].equals(","));
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

    private boolean validationStar(String value) {
        String regex = "[^\\w\\s]";
        return Pattern.matches(regex, value);
    }

    private String textCorrection(String sentence) {
        String[] text = sentence.split("");
        int index1, index2;
        String replace = "";
        if (haveBrokeOpenAndClose(text)) {
            index1 = sentence.indexOf("[");
            index2 = sentence.indexOf("]");
            String find = findWord(index1, index2, sentence);
            if (!find.isEmpty())
                return replace(sentence, find);

        } else return sentence;

        return replace;
    }

    private String replace(String text, String find) {
        if (text.contains(find) && havaNumber(find)) {
            return text.replaceAll("[^\\n]" + find, "");
        } else return text;
    }

    private boolean havaNumber(String textFind)
    {
        boolean containsNumber = false;
        String[] strings = textFind.split("");
        for (int index = 0; index < textFind.length(); index++)
        {
            if (validation(strings[index]))
                 containsNumber=true;
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
        for (int index = 0; index < array.length; index++) {
            if (array[index].contains("[")) {
                for (int i = index; i < array.length; i++) {
                    if (array[i].contains("]")) {
                        haveBroke = true;
                        break;
                    }
                }
                break;
            }

        }
        return haveBroke;
    }

}