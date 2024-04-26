import java.util.Iterator;

public class Series <E> implements Iterable<E>{
    protected SeriesGenerator<E> seriesType;

    public Series(SeriesGenerator<E> seriesType) {
        this.seriesType = seriesType;
    }

    @Override
    public Iterator<E> iterator() {
        return new SeriesIterator<>(seriesType);
    }
}
