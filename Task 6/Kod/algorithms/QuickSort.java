package algorithms;

import algorithms.pivotSelectors.*;
import core.SortingAlgorithm;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QuickSort <T> extends SortingAlgorithm<T> {
    private PivotSelector<T> pivotSelector;
    private long relinks = 0;

    public QuickSort(Comparator<? super T> comparator) {
        super(comparator);
        pivotSelector = new FirstElementPivot<T>();
    }

    public QuickSort(Comparator<? super T> comparator, PivotSelector<T> pivotSelector) {
        super(comparator);
        this.pivotSelector = pivotSelector;
    }

    private T selectPivot(List<T> list){
        return pivotSelector.selectPivot(list);
    }

    @Override
    public List<T> sort(List<T> list) {
        if (list.size() < 2){
            return list;
        }

        LinkedList<T> leftList = new LinkedList<>();
        LinkedList<T> rightList = new LinkedList<>();
        LinkedList<T> tmp = new LinkedList<>();

        T pivot = selectPivot(list);
        T element;

        for (Iterator<T> itr = list.iterator(); itr.hasNext();){
            element = itr.next();

            if (compare(element, pivot) < 0){
                leftList.addLast(element);
            }
            else{
                rightList.addLast(element);
            }
            itr.remove();
            relinks++;
        }
        tmp.addAll(sort(leftList));
        tmp.addLast(pivot);
        tmp.addAll(sort(rightList));

        list.addAll(tmp);

        return list;
    }

    @Override
    public long swaps() {
        long returnValue = relinks;
        relinks = 0;
        return returnValue;
    }
}
