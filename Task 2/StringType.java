public class StringType implements SeriesGenerator<String> {
    private String text;

    public StringType(String text) {
        this.text = text;
    }

    @Override
    public String generate(int n) {
        return text.repeat(n);
    }
}
