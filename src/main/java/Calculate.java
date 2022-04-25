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

        return sum(text.splitNumbers());
    }

    public int sum(String[] numbers) {
        int sum = 0;
        for (String string : numbers) {
            sum += convertToInteger(string);
        }
        return sum;
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
