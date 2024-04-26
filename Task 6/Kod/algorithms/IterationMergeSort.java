package algorithms;

import core.SortingAlgorithm;

import java.util.*;

public class IterationMergeSort<T> extends SortingAlgorithm<T> {

    private long relinks = 0;

    public IterationMergeSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        LinkedList<LinkedList<T>> queue = new LinkedList<>();

        for (T element : list){
            queue.addLast(new LinkedList<T>());
            queue.getLast().add(element);
        }

        while(queue.size() > 1){
            queue.addLast(merge(queue.pollFirst(), queue.pollFirst()));
        }

        list.clear();
        list.addAll(queue.getFirst());

        return list;
    }

    private LinkedList<T> merge(LinkedList<T> firstList, LinkedList<T> secondList){
        LinkedList<T> mergedList = new LinkedList<>();

        while (!firstList.isEmpty() && !secondList.isEmpty()){
            if (compare(firstList.peekFirst(), secondList.peekFirst()) <= 0){
                mergedList.addLast(firstList.pollFirst());
            }
            else{
                mergedList.addLast(secondList.pollFirst());
            }
            relinks++;
        }

        if (!firstList.isEmpty()){
            mergedList.addAll(firstList);
            relinks++;
        }
        else if (!secondList.isEmpty()){
            mergedList.addAll(secondList);
            relinks++;
        }

        return mergedList;
    }

    @Override
    public long swaps() {
        long returnValue = relinks;
        relinks = 0;
        return returnValue;
    }
}
