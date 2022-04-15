import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        else
            return sumNumbers(numbers);
    }

    public int sumNumbers(String string)
    {
        int sum = 0;
        String[] array = convertToArray(string);
        String sumNumber = "";
        for (String s : array)
        {
            if (validation(s)) {
                sumNumber = sumNumber + s;
                if (sumNumber.length() > 3) {
                    sumNumber = "";
                }
            }
             else {
                 if (!sumNumber.isEmpty()&&!sumNumber.isBlank()) {
                     sum += convertToInteger(sumNumber);
                 }
                sumNumber = "";
            }

        }
       return sum+convertToInteger(sumNumber);

    }
    private String [] convertToArray(String array)
    {
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
