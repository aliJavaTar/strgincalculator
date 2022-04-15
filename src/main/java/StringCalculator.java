import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        else
            return convertToArray(numbers);
    }

    public int convertToArray(String text)
    {
        int sum=0;
        String[] split = text.split("");
        for (String s : split)
        {
            if (validation(s))
            {
                sum=sum+sumNumbers(s);
            }
        }
        return sum;
    }

    public int sumNumbers(String number) {
        int sum = 0;
        int digit = convertToInteger(number);
        return sum + digit;
    }

    private int convertToInteger(String number) {
        return Integer.parseInt(number);
    }

    private boolean validation(String value) {
        String regex = "[0-9]+";
        return Pattern.matches(regex, value);
    }
}
