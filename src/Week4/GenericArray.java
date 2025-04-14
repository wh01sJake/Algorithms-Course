package Week4;

import java.util.Iterator;

public class GenericArray <T extends Comparable<T>> {
    private T[] data;
    private int size = 0;

    public GenericArray() {
        data = (T[]) (new Comparable[50]);
    }
    public GenericArray(int size) {
        data = (T[]) (new Comparable[size]);
    }

    public void add(T element) {
        data[size] = element;
        size++;
    }

    public int length(){
        return size;
    }



    public boolean search(T element) {
        int index = 0;
        boolean found = false;
        while (index < size && !found) {
            if (element.compareTo(data[index])==0) {
                found = true;
            }
            index++;
        }
        return found;
    }

    public void selectionSort(){
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (data[i].compareTo(data[j])>0) {
                    T temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    public void bubbleSort(){
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j+1])>0) {
                    T temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i < size; i++) { // Start from 1 up to size-1
            T temp = data[i];
            int j = i - 1;
            while (j >= 0 && data[j].compareTo(temp) > 0) { // Check if data[j] > temp
                data[j + 1] = data[j];
                j--; // Move left
            }
            data[j + 1] = temp;
        }
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public Iterator<T> iterator() {
        return  new ArrayIterator<T>(size,data);

    }
}
