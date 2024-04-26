package hashTables;

import core.HashFunction;
import core.IncrementalFunction;

import java.util.Comparator;

public class OpenAddressingHashTable<T> extends StandardHashTable<T> {

    private IncrementalFunction<T> incrementalFunction;
    private T[] array;

    public OpenAddressingHashTable(double maxLoadFactor, Comparator<? super T> comparator, HashFunction<T> hashFunction, IncrementalFunction<T> incrementalFunction, int capacity) {
        super(maxLoadFactor, comparator, hashFunction, capacity);
        this.incrementalFunction = incrementalFunction;
        this.array = (T[]) new Object[this.capacity];
    }

    public OpenAddressingHashTable(double maxLoadFactor, Comparator<? super T> comparator, HashFunction<T> hashFunction, IncrementalFunction<T> incrementalFunction) {
        this(maxLoadFactor, comparator, hashFunction, incrementalFunction, 10);
    }

    @Override
    public void insert(T object) {
        if (object == null){
            throw new IllegalArgumentException();
        }

        if (getLoadFactor() >= maxLoadFactor) {
            doubleCapacity();
        }

        int hashCode = hashFunction.hashCode(object);
        int index = hashCode % capacity;
        hashFunctionEvaluations++;

        for (int trial = 1; array[index] != null; trial++) {
            insertComparisons++;

            if(comparator.compare(object, array[index]) == 0){
                return;
            }

            index = (hashCode + incrementalFunction.shift(object, trial)) % capacity;
            collisions++;
        }

        array[index] = object;
        size++;
    }

    @Override
    public boolean lookUp(T object) {
        if (object == null){
            throw new IllegalArgumentException();
        }

        int hashCode = hashFunction.hashCode(object);
        int index = hashCode % capacity;
        hashFunctionEvaluations++;

        for (int trial = 1; array[index] != null; trial++) {
            lookUpComparisons++;

            if (comparator.compare(object, array[index]) == 0) {
                return true;
            } else {
                index = (hashCode + incrementalFunction.shift(object, trial)) % capacity;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[ ");


        for (T item : array) {
            buffer.append(item).append(", ");
        }

        buffer.setLength(buffer.length() - 2);
        buffer.append(" ]");

        return buffer.toString();
    }

    private void doubleCapacity() {
        capacity *= 2;
        size = 0;

        T[] tmp = array;
        array = (T[]) new Object[capacity];

        for (T item : tmp){
            if (item != null){
                insert(item);
            }
        }
    }
}
