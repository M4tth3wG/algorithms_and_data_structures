import java.util.Iterator;
import java.util.ListIterator;

public class OneWayLinkedListWithSentinel<E> implements IList<E> {
    private Element<E> sentinel;
    private int size = 0;

    public OneWayLinkedListWithSentinel() {
        this.sentinel = new Element<E>(null);

    }

    @Override
    public boolean add(E e) {
        Element<E> newElement = new Element<>(e);
        Element<E> tail = sentinel;

        while (tail.getNext() != null) {
            tail = tail.getNext();
        }

        tail.setNext(newElement);
        size++;

        return true;
    }

    //TODO
    @Override
    public void add(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Element<E> newElem = new Element<>(element);
        Element<E> prevElem = getElement(index - 1);

        newElem.setNext(prevElem.getNext());
        prevElem.setNext(newElem);
        size++;
    }

    private Element<E> getElement(int index) {
        if (index < -1) {
            throw new IndexOutOfBoundsException();
        }

        Element<E> actElem;

        if(index == -1){
            actElem = sentinel;
        }
        else{
            actElem = sentinel.getNext();
        }


        while (index > 0 && actElem != null) {
            index--;
            actElem = actElem.getNext();
        }

        if (actElem == null) {
            throw new IndexOutOfBoundsException();
        }
        return actElem;
    }


    @Override
    public void clear() {
        this.sentinel.setNext(null);
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Element<E> actElem = getElement(index);
        return actElem.getValue();
    }

    @Override
    public E set(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Element<E> actElem = getElement(index);
        E elemData = actElem.getValue();
        actElem.setValue(element);
        return elemData;
    }

    @Override
    public int indexOf(E element) {
        int pos = -1;
        Element<E> actElem = sentinel;

        while (actElem != null) {
            if (element.equals(actElem.getValue())) {
                return pos;
            }
            pos++;
            actElem = actElem.getNext();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.getNext() == null;
    }

    //TODO
    @Override
    public E remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Element<E> prevElem = getElement(index - 1);

        if (prevElem.getNext() == null) {
            throw new IndexOutOfBoundsException();
        }

        E retValue = prevElem.getNext().getValue();
        prevElem.setNext(prevElem.getNext().getNext());

        size--;
        return retValue;
    }

    //TODO
    @Override
    public boolean remove(E element) {
        remove(indexOf(element));
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    public void reverse(){
        if (isEmpty()){
            return;
        }

        Element<E> actElem = sentinel.getNext();
        Element<E> nextElem = actElem.getNext();
        Element<E> firstElem = actElem;


        while (nextElem != null){
            actElem.setNext(nextElem.getNext());
            sentinel.setNext(nextElem);
            nextElem.setNext(firstElem);
            firstElem = nextElem;

            nextElem = actElem.getNext();
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append('[');

        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                E item = this.get(i);
                buffer.append(item).append(", ");
            }

            buffer.setLength(buffer.length() - 2);
        }

        buffer.append(']');
        return buffer.toString();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    private static class Element<E> {
        private E value;
        private Element<E> next;

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Element<E> getNext() {
            return next;
        }

        public void setNext(Element<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "value=" + value +
                    ", next=" + next.value +
                    '}';
        }

        Element(E data) {
            this.value = data;
        }
    }
}
