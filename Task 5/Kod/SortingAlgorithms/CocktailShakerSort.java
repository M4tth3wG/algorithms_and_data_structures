package SortingAlgorithms;

import core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class CocktailShakerSort<T> extends SortingAlgorithm<T> {

    public CocktailShakerSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {

        for (int pass = 1, beginning = 0, end = list.size() - 1; beginning <= end; ++pass) {
            for (int left = beginning; left < end; ++left) {
                int right = left + 1;

                if (compare(list.get(left), list.get(right)) > 0) {
                    swap(list, left, right);
                }
            }
            end--;

            if (beginning >= end){
                break;
            }

            for (int right = end; right > beginning; --right) {
                int left = right - 1;

                if (compare(list.get(left), list.get(right)) > 0) {
                    swap(list, left, right);
                }
            }
            beginning++;
        }
        return list;
    }
}
