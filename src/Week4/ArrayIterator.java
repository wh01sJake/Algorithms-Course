package Week4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator <T> implements Iterator<T>{
    private int index;
    private int size;
    private T[] array;

    public ArrayIterator(int size, T[] array) {
        this.index = index;
        this.size = size;
        this.array = array;
    }

    public boolean hasNext() {
        return index < size;
    }

    public T next() {
        if (index == size) {
            throw new NoSuchElementException();
        }

        return array[index++];
    }
}
