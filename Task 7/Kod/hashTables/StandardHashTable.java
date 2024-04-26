package hashTables;

import core.HashFunction;
import core.HashTable;
import core.IncrementalFunction;

import java.util.Comparator;

public abstract class StandardHashTable<T> extends HashTable<T>{

    protected HashFunction<T> hashFunction;
    protected int capacity;
    protected int size = 0;
    protected int collisions = 0;
    protected int insertComparisons = 0;
    protected int lookUpComparisons = 0;
    protected int hashFunctionEvaluations = 0;

    public StandardHashTable(double maxLoadFactor, Comparator<? super T> comparator, HashFunction<T> hashFunction, int capacity) {
        super(maxLoadFactor, comparator);

        if (maxLoadFactor <= 0 || maxLoadFactor > 1){
            throw new IllegalArgumentException();
        }

        this.hashFunction = hashFunction;

        if (capacity < 1){
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
    }

    public StandardHashTable(double maxLoadFactor, Comparator<? super T> comparator, HashFunction<T> hashFunction) {
        this(maxLoadFactor, comparator, hashFunction, 10);
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int collisions() {
        return collisions;
    }

    @Override
    public int insertComparisons() {
        return insertComparisons;
    }

    @Override
    public int lookUpComparisons() {
        return lookUpComparisons;
    }

    @Override
    public int hashFunctionEvaluations() {
        return hashFunctionEvaluations;
    }

    public double getLoadFactor() {
        return (double) size / capacity;
    }

}
