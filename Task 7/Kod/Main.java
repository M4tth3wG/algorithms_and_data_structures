import core.HashTable;
import hashFunctions.StandardHashFunction;
import hashTables.OpenAddressingHashTable;
import hashTables.SeparateChainingHashTable;
import incrementalFunctions.LinearIncrementalFunction;
import incrementalFunctions.QuadraticIncrementalFunction;

import javax.sound.sampled.Line;

public class Main {
    public static void main(String[] args) {

        System.out.println("OpenAddressingHashTable(maxLoadFactor = 0.2, LinearIncrementalFunction) Test:\n");

        HashTable<Integer> hashTable1 = new OpenAddressingHashTable<>(0.9, Integer::compareTo, new StandardHashFunction<>(), new LinearIncrementalFunction<>());

        hashTable1.insert(6);
        System.out.println(hashTable1);

        hashTable1.insert(16);
        System.out.println(hashTable1);

        hashTable1.insert(9);
        System.out.println(hashTable1);

        hashTable1.insert(29);
        System.out.println(hashTable1);

        hashTable1.insert(21);
        System.out.println(hashTable1);

        System.out.println("Size: " + hashTable1.size());
        System.out.println("Capacity: " + hashTable1.capacity());
        System.out.println("LoadFactor: " + hashTable1.loadFactor());
        System.out.println("lookUp(21): " + hashTable1.lookUp(21));
        System.out.println("lookUp(5): " + hashTable1.lookUp(5));



        System.out.println("\nOpenAddressingHashTable(maxLoadFactor = 0.2, QuadraticIncrementalFunction) Test:\n");

        HashTable<Integer> hashTable2 = new OpenAddressingHashTable<>(0.9, Integer::compareTo, new StandardHashFunction<>(), new QuadraticIncrementalFunction<>());

        hashTable2.insert(6);
        System.out.println(hashTable2);

        hashTable2.insert(16);
        System.out.println(hashTable2);

        hashTable2.insert(9);
        System.out.println(hashTable2);

        hashTable2.insert(29);
        System.out.println(hashTable2);

        hashTable2.insert(21);
        System.out.println(hashTable2);

        System.out.println("Size: " + hashTable2.size());
        System.out.println("Capacity: " + hashTable2.capacity());
        System.out.println("LoadFactor: " + hashTable2.loadFactor());
        System.out.println("lookUp(21): " + hashTable2.lookUp(21));
        System.out.println("lookUp(5): " + hashTable2.lookUp(5));



        System.out.println("\nSeparateChainingHashTable(maxLoadFactor = 0.2) Test:\n");

        HashTable<Integer> hashTable3 = new SeparateChainingHashTable<>(0.9, Integer::compareTo, new StandardHashFunction<>());

        hashTable3.insert(6);
        System.out.println(hashTable3);

        hashTable3.insert(16);
        System.out.println(hashTable3);

        hashTable3.insert(9);
        System.out.println(hashTable3);

        hashTable3.insert(29);
        System.out.println(hashTable3);

        hashTable3.insert(21);
        System.out.println(hashTable3);

        System.out.println("Size: " + hashTable3.size());
        System.out.println("Capacity: " + hashTable3.capacity());
        System.out.println("LoadFactor: " + hashTable3.loadFactor());
        System.out.println("lookUp(21): " + hashTable3.lookUp(21));
        System.out.println("lookUp(5): " + hashTable3.lookUp(5));

    }
}
