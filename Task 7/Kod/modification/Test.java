package modification;

import core.HashTable;
import hashFunctions.StandardHashFunction;
import hashTables.OpenAddressingHashTable;
import hashTables.SeparateChainingHashTable;
import incrementalFunctions.LinearIncrementalFunction;
import incrementalFunctions.QuadraticIncrementalFunction;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("Jan", "Kowalski", 20);
        Student student2 = new Student("Adam", "Kowalski", 21);
        Student student3 = new Student("Jan", "Nowak", 19);
        Student student4 = new Student("Jan", "Nowak", 19);
        Student student5 = new Student("Jacek", "Nowak", 22);

        float[] grades1 = {3.0f, 4.5f, 5.0f, 3.5f};
        float[] grades2 = {3.5f, 4.0f, 5.5f, 4.5f};
        float[] grades3 = {4.5f, 5.0f, 3.0f, 3.5f};

        student1.addGrades(grades1);
        student2.addGrades(grades1);
        student3.addGrades(grades2);
        student4.addGrades(grades3);

        System.out.println("OpenAddressingHashTable(maxLoadFactor = 0.2, LinearIncrementalFunction) Test:\n");

        HashTable<Student> hashTable1 = new OpenAddressingHashTable<>(0.2, new StudentComparator(), new StudentHashFunction(), new LinearIncrementalFunction<>());

        hashTable1.insert(student1);
        System.out.println(hashTable1);

        hashTable1.insert(student2);
        System.out.println(hashTable1);

        hashTable1.insert(student3);
        System.out.println(hashTable1);

        hashTable1.insert(student4);
        System.out.println(hashTable1);

        System.out.println("Size: " + hashTable1.size());
        System.out.println("Capacity: " + hashTable1.capacity());
        System.out.println("LoadFactor: " + hashTable1.loadFactor());
        System.out.println("lookUp(student1): " + hashTable1.lookUp(student1));
        System.out.println("lookUp(student5): " + hashTable1.lookUp(student5));



        System.out.println("\nOpenAddressingHashTable(maxLoadFactor = 0.2, QuadraticIncrementalFunction) Test:\n");

        HashTable<Student> hashTable2 = new OpenAddressingHashTable<>(0.2, new StudentComparator(), new StudentHashFunction(), new QuadraticIncrementalFunction<>());

        hashTable2.insert(student1);
        System.out.println(hashTable2);

        hashTable2.insert(student2);
        System.out.println(hashTable2);

        hashTable2.insert(student3);
        System.out.println(hashTable2);

        hashTable2.insert(student4);
        System.out.println(hashTable2);

        System.out.println("Size: " + hashTable2.size());
        System.out.println("Capacity: " + hashTable2.capacity());
        System.out.println("LoadFactor: " + hashTable2.loadFactor());
        System.out.println("lookUp(student1): " + hashTable2.lookUp(student1));
        System.out.println("lookUp(student5): " + hashTable2.lookUp(student5));



        System.out.println("\nSeparateChainingHashTable(maxLoadFactor = 0.2) Test:\n");

        HashTable<Student> hashTable3 = new SeparateChainingHashTable<>(0.2, new StudentComparator(), new StudentHashFunction());

        hashTable3.insert(student1);
        System.out.println(hashTable3);

        hashTable3.insert(student2);
        System.out.println(hashTable3);

        hashTable3.insert(student3);
        System.out.println(hashTable3);

        hashTable3.insert(student4);
        System.out.println(hashTable3);

        System.out.println("Size: " + hashTable3.size());
        System.out.println("Capacity: " + hashTable3.capacity());
        System.out.println("LoadFactor: " + hashTable3.loadFactor());
        System.out.println("lookUp(student1): " + hashTable3.lookUp(student1));
        System.out.println("lookUp(student5): " + hashTable3.lookUp(student5));

    }
}
