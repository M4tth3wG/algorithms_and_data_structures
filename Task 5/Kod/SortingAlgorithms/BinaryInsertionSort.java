package SortingAlgorithms;

import core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class BinaryInsertionSort<T> extends SortingAlgorithm<T> {

    public BinaryInsertionSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        int left;

        for (int right = 1; right < list.size(); ++right) {
            left =  binarySearch(list, right);

            for (int i = left; i < right; ++i){
                swap(list, i, right);
            }
        }
        return list;
    }

    private int binarySearch(List<T> list, int itemIndex){
        T item = list.get(itemIndex);
        int mid;
        int low = 0;
        int high = itemIndex - 1;

        while (high - low > 1){
            mid = (low + high) / 2;

            if(compare(list.get(mid), item) <= 0){
                low = mid;
            }
            else if (compare(list.get(mid), item) > 0){
                high = mid;
            }
        }

        if (compare(item, list.get(high)) >= 0){
            return high + 1;
        }
        else if (compare(item, list.get(low)) >= 0){
            return high;
        }
        return low;
    }
}
