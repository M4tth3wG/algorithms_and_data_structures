import javax.lang.model.element.Element;
import java.lang.reflect.Array;
import java.util.*;

public class TwoWayArrayLinkedList<E> implements IList<E> {
    private int arrSize;
    private int size = 0;
    private Element<E> head = null;

    public TwoWayArrayLinkedList(int arrSize) {
        this.arrSize = arrSize;
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new IllegalArgumentException();
        }

        if (head == null) {
            head = new Element<>(arrSize);
        }

        Element<E> element = findSpace();
        E[] array = element.innerArray;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = e;
                element.size++;
                size++;
                break;
            }
        }
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Element<E> current = head;
        int pos = -1;

        while (pos + current.size < index) {
            pos += current.size;
            current = current.getNext();
        }

        E[] array = current.innerArray;
        List<E> tmp = new ArrayList<>();

        for (int i = index - pos - 1, j = 0; j < array.length; j++) {
            if (i == 0) {
                tmp.add(element);
                current.size++;
                size++;
                i--;
                j--;
            } else if (array[j] != null) {
                tmp.add(array[j]);
                i--;
            }
        }

        if (current.size > arrSize) {
            Element<E> newElem = new Element<>(arrSize);
            Element<E> next = current.getNext();
            newElem.setPrevious(current);
            newElem.setNext(next);
            current.setNext(newElem);
            if (next != null) {
                next.setPrevious(newElem);
            }

            newElem.innerArray[0] = array[arrSize - 1];
            newElem.size++;
            current.size = arrSize;
            tmp.remove(arrSize);
        }

        Object[] helper = tmp.toArray(new Object[arrSize]);
        current.innerArray = (E[]) helper;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Element<E> current = head;
        E value = null;
        int pos = -1;

        while (pos + current.size < index) {
            pos += current.size;
            current = current.getNext();
        }
        E[] array = current.innerArray;

        for (int i = index - pos - 1, j = 0; j < array.length; j++) {
            if (array[j] != null) {
                i--;
            }
            if (i < 0) {
                value = array[j];
                break;
            }
        }
        return value;
    }

    @Override
    public E set(int index, E element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Element<E> current = head;
        E value = null;
        int pos = -1;

        while (pos + current.size < index) {
            pos += current.size;
            current = current.getNext();
        }
        E[] array = current.innerArray;

        for (int i = index - pos - 1, j = 0; j < array.length; j++) {
            if (array[j] != null) {
                i--;
            }
            if (i < 0) {
                value = array[j];
                array[j] = element;
                break;
            }
        }
        return value;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        int pos = 0;
        Element<E> current = head;

        while (current != null) {
            E[] array = current.innerArray;

            for (E e : array) {
                if (element.equals(e)) {
                    return pos;
                } else if (e != null) {
                    pos++;
                }
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Element<E> current = head;
        E value = null;
        int pos = -1;

        while (pos + current.size < index) {
            pos += current.size;
            current = current.getNext();
        }
        E[] array = current.innerArray;

        for (int i = index - pos - 1, j = 0; j < array.length; j++) {
            if (array[j] != null) {
                i--;
            }
            if (i < 0) {
                value = array[j];
                array[j] = null;
                current.size--;
                size--;

                break;
            }
        }
        if (current.size == 0) {
            deleteElement(current);
        }
        return value;
    }

    @Override
    public boolean remove(E element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        Element<E> current = head;

        while (current != null) {
            E[] array = current.innerArray;

            for (int i = 0; i < array.length; i++) {
                if (element.equals(array[i])) {
                    array[i] = null;
                    current.size--;
                    size--;
                    if (current.size == 0) {
                        deleteElement(current);
                    }
                    return true;
                }
            }
            current = current.getNext();
        }
        return false;
    }

    public int totalCapacity() {
        int totalCapacity = 0;
        Element<E> current = head;

        while (current != null) {
            totalCapacity += (arrSize - current.size);
            current = current.getNext();
        }
        return totalCapacity;
    }

    public int endCapacity() {
        if (isEmpty()) {
            return 0;
        }

        Element<E> current = head;
        Element<E> previous = null;

        while (current != null) {
            previous = current;
            current = current.getNext();
        }
        return previous.endCapacity();

    }

    private void deleteElement(Element<E> element) {
        if (element == head) {
            head = element.getNext();
            if (head != null) {
                head.setPrevious(null);
            }
            else{
                return;
            }
        } else if (element.getNext() == null) {
            element.getPrevious().setNext(null);
        }

        Element<E> previous = element.getPrevious();
        Element<E> next = element.getNext();

        if (next != null){
            previous.setNext(next);
            next.setPrevious(previous);
        }

    }

    public void defrag() {
        Element<E> current = head;
        Element<E> previous;
        int elementsToMove = 0;

        while (current != null){
            previous = current.getPrevious();

            if(previous != null && previous.size != arrSize){
                if (arrSize - previous.size <= current.size){
                    elementsToMove = arrSize - previous.size;
                }
                else{
                    elementsToMove = current.size;
                }
                current.move(elementsToMove);
                if (current.size == 0){
                    deleteElement(current);
                    current = previous.getNext();
                    continue;
                }
            }

            if (current.size != arrSize){
                current.defrag();
            }
            current = current.getNext();
        }
    }

    @Override
    public int size() {
        return size;
    }

    private Element<E> findSpace() {
        Element<E> current = head;
        Element<E> previous = null;

        while (current != null && (arrSize - current.size) == 0) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            previous.setNext(new Element<>(arrSize));
            current = previous.getNext();
            current.setPrevious(previous);
        }

        return current;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append('[');
        Element<E> current = head;

        if (!isEmpty()) {
            while (current != null) {
                E[] array = current.innerArray;
                for (E elem : array) {
                    if (elem != null) {
                        buffer.append(elem).append(", ");
                    }
                }
                current = current.getNext();
            }

            buffer.setLength(buffer.length() - 2);
        }

        buffer.append(']');
        return buffer.toString();
    }

    public void testPrint() {
        StringBuffer buffer = new StringBuffer();
        buffer.append('{');
        Element<E> current = head;

        if (!isEmpty()) {
            while (current != null) {
                E[] array = current.innerArray;
                buffer.append(Arrays.toString(array)).append(", ");
                current = current.getNext();
            }

            buffer.setLength(buffer.length() - 2);
        }

        buffer.append('}');
        System.out.println(buffer);
    }

    private static class Element<E> {
        private E[] innerArray;
        private int size = 0;
        private Element<E> next = null;
        private Element<E> previous = null;

        public Element(int arrSize) {
            Object[] tmp = new Object[arrSize];
            this.innerArray = (E[]) tmp;
        }

        private int endCapacity() {
            int counter = 0;

            for (int i = innerArray.length - 1; i >= 0; i--) {
                if (innerArray[i] == null) {
                    counter++;
                } else {
                    break;
                }
            }
            return counter;
        }

        private void defrag(){
            for (int i = 0, j = 0; i < innerArray.length; i++){
                if (innerArray[i] != null){
                    if (j != i){
                        innerArray[j] = innerArray[i];
                        innerArray[i] = null;
                    }
                    j++;
                }
            }
        }

        private void move(int elementsToMove){
            int previousIndex = previous.size;
            E[] prevArr = getPrevious().innerArray;

            for (int i = 0; i < innerArray.length && elementsToMove > 0; i++){
                if (innerArray[i] != null){
                    prevArr[previousIndex++] = innerArray[i];
                    innerArray[i] = null;
                    previous.size++;
                    size--;
                    elementsToMove--;
                }
            }
        }

        public Element<E> getNext() {
            return next;
        }

        public void setNext(Element<E> next) {
            this.next = next;
        }

        public Element<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Element<E> previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "array=" + Arrays.toString(innerArray) +
                    ", next=" + Arrays.toString(next.innerArray) +
                    '}';
        }

    }
}
