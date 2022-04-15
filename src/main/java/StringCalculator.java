import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        else
            return sumNumbers(numbers);
    }

    public int sumNumbers(String string) {
        int sum = 0;
        String[] array = convertToArray(string);
        String sumNumber = "";

        for (int index = 0; index < array.length; index++) {
            if (validation(array[index])) {
                if (index > 1) {
                    if (array[index].equals("1") &&
                            array[index].equals("1") && ( validationStar(array[index-1]) && validationStar(array[index+1])) &&
                            (!array[index - 1].equals(",") &&
                                    !array[index + 1].equals(",")))
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

//    public String specificMethod(String[] array, int index) {
//
//        if (
//                array[index].equals("1") &&
//                        validationStar(array[index - 1])
//                        && validationStar(array[index - 1]) &&
//                        !array[index - 1].equals(",") &&
//                        !array[index + 1].equals(",") && index > 2)
//        {
//            return "0";
//        }
//        else return "1";
//    }

    // if number 1 between to char so ...
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
}
