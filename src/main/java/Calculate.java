public class Calculate {
    private Text text;

    public Calculate() {
        this.text = new Text();
    }

    public Calculate(Text text) {
        this.text = text;
    }

    public void setInputText(String text) {
        this.text.setInputText(text);
    }

    public int add() {
        if (text.isEmpty())
            return 0;
        try {
            text.negativesNotAllowed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return -1;
        }
        return sum(text.splitNumbers());
    }

    public int sum(String[] numbers) {
        int sum = 0, tempNumber;
        for (String num : numbers) {
            tempNumber = convertToInteger(num);

            if (isBiggerThan1000(tempNumber))
                continue;
            sum += tempNumber;
        }
        return sum;
    }

    private boolean isBiggerThan1000(int number) {
        return number > 1000;
    }

    private int convertToInteger(String numbers) {
        return Integer.parseInt(numbers);
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
