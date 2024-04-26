import java.util.Iterator;

public class FiniteSeries<E> extends Series<E>{
    private int limit;

    public FiniteSeries(SeriesGenerator<E> seriesType, int limit) {
        super(seriesType);
        this.limit = limit;
    }

    @Override
    public Iterator<E> iterator() {
        return new SeriesIterator<>(seriesType, limit);
    }
}
