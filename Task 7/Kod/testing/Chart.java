package testing;

import core.HashFunction;
import core.HashTable;
import core.IncrementalFunction;
import hashFunctions.StandardHashFunction;
import hashTables.OpenAddressingHashTable;
import hashTables.SeparateChainingHashTable;
import hashTables.StandardHashTable;
import incrementalFunctions.LinearIncrementalFunction;
import incrementalFunctions.QuadraticIncrementalFunction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Chart<T> {
    private List<StandardHashTable<T>> hashTables;
    private int[] sizes;
    private Generator<T> generator;

    public static void main(String[] args) {
        int[] sizes = {5, 10, 50, 75, 100, 250, 500, 1000, 2500, 5000, 7500, 10000};
        Chart<Integer> chart = new Chart<>(sizes, new RandomIntegerArrayGenerator(10000000));

        double[] maxLoadFactors = {0.1, 0.2, 0.5, 0.9};
        Comparator<Integer> comparator = Integer::compareTo;
        HashFunction<Integer> hashFunction = new StandardHashFunction<Integer>();
        IncrementalFunction<Integer> incrementalFunction = new QuadraticIncrementalFunction<>();
        int capacity = 10;

        for (double maxLoadFactor : maxLoadFactors){
            System.out.println("\nMaxLoadFactor: " + maxLoadFactor + "\n");

            for (int size : sizes){
                chart.hashTables.add(new SeparateChainingHashTable<>(maxLoadFactor, comparator, hashFunction, capacity));
            }

            for (String string : chart.generate()){
                System.out.println(string);
            }
        }

    }

    public Chart(int[] sizes, Generator<T> generator) {
        this.sizes = sizes;
        this.generator = generator;
        hashTables = new ArrayList<>();
    }

    public List<String> generate(){
        List<String> chartList = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < sizes.length; i ++){
            List<T> values = new ArrayList<>(generator.generate(sizes[i]));
            StandardHashTable<T> hashTable = hashTables.get(i);
            buffer.delete(0, buffer.length());

            for (T value : values){
                hashTable.insert(value);
            }

            buffer.append(hashTable.getLoadFactor()).append(";");
            buffer.append(hashTable.collisions()).append(";");
            buffer.append(hashTable.hashFunctionEvaluations()).append(";");
            buffer.append(hashTable.insertComparisons());

            chartList.add(buffer.toString());
        }

        return chartList;
    }

}
