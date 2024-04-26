package SortingAlgorithms;

import core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class SelectionSortWithMaxAndMin<T> extends SortingAlgorithm<T> {

    public SelectionSortWithMaxAndMin(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {

        for (int start = 0, end = list.size() - 1; start < end; ++start, --end){
            int min = start;
            int max = start;

            for (int i = start; i <= end; ++i){
                if (compare(list.get(i), list.get(min)) < 0){
                    min = i;
                }
                if (compare(list.get(i), list.get(max)) >= 0){
                    max = i;
                }
            }

            if (start != min){
                swap(list, start, min);
            }

            if (max == start){
                max = min;
            }

            if (max != end){
                swap(list, end, max);
            }

        }

        return list;
    }
}
