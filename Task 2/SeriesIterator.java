import java.util.Iterator;

public class SeriesIterator<E> implements Iterator<E> {
    private int pos = 1;
    private int limit = 0;
    private SeriesGenerator<E> generator;

    public SeriesIterator(SeriesGenerator<E> generator) {
        this.generator = generator;
    }

    public SeriesIterator(SeriesGenerator<E> generator, int limit) {
        this.generator = generator;
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        if (limit == 0 || pos <= limit){
            return true;
        }
        return false;
    }

    @Override
    public E next() {
        if (hasNext()){
            return generator.generate(pos++);
        }
        return null;
    }

}
