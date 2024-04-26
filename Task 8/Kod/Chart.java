import com.sun.source.tree.Tree;
import generation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chart {
    public static void main(String[] args) {
        Generator<Integer> generator = new ReversedIntegerArrayGenerator();
        Heap<Integer> heap = new TreeHeap<>(Integer::compareTo);
        int[] sizes = {10000, 25000, 50000, 100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000, 550000, 600000, 650000, 700000, 750000, 800000, 850000, 900000, 950000, 1000000};
        PriorityQueueSorter<Integer> sorter = new PriorityQueueSorter<>(heap);

        for(int size : sizes){
            sorter.sort(generator.generate(size));
            System.out.println(sorter.getTime());
        }
    }
}
