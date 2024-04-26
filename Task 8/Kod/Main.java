import generation.Generator;
import generation.RandomIntegerArrayGenerator;
import generation.ReversedIntegerArrayGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Heap<Integer> arrayHeap = new ArrayHeap<>(2, Integer::compareTo);
        Heap<Integer> treeHeap = new TreeHeap<>(Integer::compareTo);

        arrayHeap.add(5);
        arrayHeap.add(12);
        arrayHeap.add(1);
        arrayHeap.add(6);
        arrayHeap.add(2);

        System.out.println("\nArrayHeap: \n" + arrayHeap);
        System.out.println("\nArrayHeap.minimum(): \n" + arrayHeap.minimum());
        System.out.println("\nArrayHeap: \n" + arrayHeap);
        System.out.println("\nArrayHeap.clear()\n");
        arrayHeap.clear();
        System.out.println("\nArrayHeap: \n" + arrayHeap);

        treeHeap.add(5);
        treeHeap.add(12);
        treeHeap.add(1);
        treeHeap.add(6);
        treeHeap.add(2);

        System.out.println("\nTreeHeap: \n" + treeHeap);
        System.out.println("\nTreeHeap.minimum(): \n" + treeHeap.minimum());
        System.out.println("\nTreeHeap: \n" + treeHeap);
        System.out.println("\nTreeHeap.clear()\n");
        treeHeap.clear();
        System.out.println("\nTreeHeap: \n" + treeHeap);


        System.out.println("\nSorting test:\n");
        Generator<Integer> generator = new RandomIntegerArrayGenerator(100);
        Heap<Integer> heap = new TreeHeap<>(Integer::compareTo);
        PriorityQueueSorter<Integer> sorter = new PriorityQueueSorter<>(heap);
        List<Integer> list = generator.generate(10);

        System.out.println("Original list: " + list);
        System.out.println("Sorted list: " + sorter.sort(list));
    }
}
