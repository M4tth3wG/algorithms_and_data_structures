package hashTables;

import core.HashFunction;
import core.HashTable;

import java.util.Comparator;
import java.util.LinkedList;

public class SeparateChainingHashTable<T> extends StandardHashTable<T> {
    private LinkedList<T>[] array;

    public SeparateChainingHashTable(double maxLoadFactor, Comparator<? super T> comparator, HashFunction<T> hashFunction, int capacity) {
        super(maxLoadFactor, comparator, hashFunction, capacity);
        this.array =  new LinkedList[capacity];
    }

    public SeparateChainingHashTable(double maxLoadFactor, Comparator<? super T> comparator, HashFunction<T> hashFunction) {
        this(maxLoadFactor, comparator, hashFunction, 10);
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

        if (array[index] != null) {
            collisions++;

            for (T item : array[index]) {
                insertComparisons++;

                if (comparator.compare(object, item) == 0) {
                    return;
                }
            }
            array[index].addLast(object);

        } else {
            array[index] = new LinkedList<>();
            array[index].add(object);
        }

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

        if (array[index] != null) {
            for (T item : array[index]) {
                lookUpComparisons++;

                if (comparator.compare(object, item) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[ ");

        for (LinkedList<T> list : array) {
            if (list != null){
                for (T item : list) {
                    buffer.append(item).append(", ");
                }
                buffer.setLength(buffer.length() - 2);
            }
            buffer.append(" | ");
        }
        buffer.setLength(buffer.length() - 3);
        buffer.append(" ]");

        return buffer.toString();
    }

    private void doubleCapacity() {
        capacity *= 2;
        size = 0;

        LinkedList<T>[] tmp = array;
        array = new LinkedList[capacity];

        for (LinkedList<T> list : tmp) {
            if (list != null) {
                for (T item : list) {
                    insert(item);
                }
            }
        }
    }
}
