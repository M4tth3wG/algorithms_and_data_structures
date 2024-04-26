import java.util.List;
import java.util.ListIterator;

public class PriorityQueueSorter<T> {
    Heap<T> heap;
    Timer timer;

    public PriorityQueueSorter(Heap<T> heap) {
        this.heap = heap;
        timer = new Timer();
    }

    public List<T> sort(List<T> list){
        heap.clear();
        timer.reset();

        timer.start();
        heapAssembly(list);

        replaceAllInOrder(list);
        timer.stop();

        return list;
    }

    public long getTime(){
        return timer.getTimeInMillis();
    }

    private void heapAssembly(List<T> list){
        for (T element : list){
            heap.add(element);
        }
    }

    private void replaceAllInOrder(List<T> list){
        for (ListIterator<T> itr = list.listIterator(); itr.hasNext();){
            itr.next();
            itr.set(heap.minimum());
        }
    }
}
