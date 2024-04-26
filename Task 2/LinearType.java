public class LinearType implements SeriesGenerator<Integer> {
    private int a;

    public LinearType(int a){
        this.a = a;
    }

    @Override
    public Integer generate(int n) {
        return n*a;
    }
}
