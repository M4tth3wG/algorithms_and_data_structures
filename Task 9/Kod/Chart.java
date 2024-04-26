import core.BinarySearchTree;
import core.HeapyBinarySearchTree;
import generation.ShuffledIntegerArrayListGenerator;
import performance.PerformanceTester;

public class Chart {
    public static void main(String[] args) {
        PerformanceTester<Integer> pt = new PerformanceTester<>(new ShuffledIntegerArrayListGenerator(), new HeapyBinarySearchTree<>(Integer::compareTo));
        int[] sizes = {10_000, 25_000, 50_000, 75_000, 100_000, 250_000, 500_000, 750_000, 1_000_000};

        pt.addingTest(sizes);
        pt.findingTest(sizes);
        pt.removingTest(sizes);
    }
}
