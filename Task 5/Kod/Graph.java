import SortingAlgorithms.CocktailShakerSort;
import core.SortingAlgorithm;
import testing.MarkedValue;
import testing.Result;
import testing.Tester;
import testing.comparators.IntegerComparator;
import testing.comparators.MarkedValueComparator;
import testing.generation.Generator;
import testing.generation.ShuffledIntegerArrayGenerator;
import testing.generation.conversion.MarkingGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Graph {
    public static void main(String[] args) {
        Comparator<MarkedValue<Integer>> markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

        Generator<MarkedValue<Integer>> generator = new MarkingGenerator<Integer>(new ShuffledIntegerArrayGenerator());

        SortingAlgorithm<MarkedValue<Integer>> algorithm = new CocktailShakerSort<>(markedComparator);

        int[] sizes = {10, 50, 100, 250, 500, 1000, 2500, 5000, 7500, 10000};
        List<String> comparisonsAvg = new ArrayList<>();
        List<String> comparisonsDev = new ArrayList<>();
        List<String> swapsAvg = new ArrayList<>();
        List<String> swapsDev = new ArrayList<>();
        List<String> timeAvg = new ArrayList<>();
        List<String> timeDev = new ArrayList<>();

        for(int size : sizes){
            Result result = Tester.runNTimes(algorithm, generator, size, 20);

            comparisonsAvg.add(double2String(result.averageComparisons()));
            comparisonsDev.add(double2String(result.comparisonsStandardDeviation()));

            swapsAvg.add(double2String(result.averageSwaps()));
            swapsDev.add(double2String(result.swapsStandardDeviation()));

            timeAvg.add(double2String(result.averageTimeInMilliseconds()));
            timeDev.add(double2String(result.timeStandardDeviation()));
        }
        System.out.println("Comp AVG");
        printColumn(comparisonsAvg);

        System.out.println("Comp DEV");
        printColumn(comparisonsDev);

        System.out.println("Swaps AVG");
        printColumn(swapsAvg);

        System.out.println("Swaps DEV");
        printColumn(swapsDev);

        System.out.println("Time AVG");
        printColumn(timeAvg);

        System.out.println("Time DEV");
        printColumn(timeDev);

    }

    private static void printStatistic(String label, double average, double stdDev) {
        System.out.println(label + ": " + double2String(average) + " +- " + double2String(stdDev));
    }

    private static String double2String(double value) {
        return String.format("%.12f", value);
    }

    private static void printColumn(List<String> list){
        for (String s : list){
            System.out.println(s);
        }
        System.out.println("\n\n");
    }
}
