import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        SeriesIterator<Integer> iter1 = new SeriesIterator<>(new LinearType(2), 3);

        System.out.println("\nLinearSeries(a = 2, limit = 3):\n");
        for(int i = 1; i < 10; i++){
            System.out.println("n: " + i + " hasNext: " + iter1.hasNext() + " value: " + iter1.next());
        }

        SeriesIterator<String> iter2 = new SeriesIterator<>(new StringType("La"));

        System.out.println("\nStringSeries(text = \"La\", limit = 0):\n");
        for(int i = 1; i < 10; i++){
            System.out.println("n: " + i + " hasNext: " + iter2.hasNext() + " value: " + iter2.next());
        }

        System.out.println("\nLinear series(a = 5, limit = 10):\n");
        Series<Integer> linearSeries1 = new FiniteSeries<>(new LinearType(5), 10);
        for(int i : linearSeries1){
            System.out.println(i);
        }

        System.out.println("\nLinear series(a = 0, limit = 5):\n");
        Series<Integer> linearSeries2 = new FiniteSeries<>(new LinearType(0), 5);
        for(int i : linearSeries2){
            System.out.println(i);
        }

        System.out.println("\nString series(text = \"La\", limit = 10):\n");
        Series<String> stringSeries1 = new FiniteSeries<>(new StringType("La"), 10);
        for(String s : stringSeries1){
            System.out.println(s);
        }

        System.out.println("\nString series(text = \"La \", limit = 5):\n");
        Series<String> stringSeries2 = new Series<>(new StringType("La "));
        for(String s : stringSeries2){
            System.out.println(s);
        }

    }
}
