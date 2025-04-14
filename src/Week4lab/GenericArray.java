package Week4lab;

public class GenericArray <T extends Comparable <T>> {
    private T[] array;
    private int size;

    public GenericArray(T[] array) {
        this.array = array;
        this.size = array.length;
    }

    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size-i-1; j++) {
                if (array[j].compareTo(array[j+1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public void insertionSort() {}



}
