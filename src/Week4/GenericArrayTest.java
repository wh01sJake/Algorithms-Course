package Week4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class GenericArrayTest {
    public static void main(String[] args) {
        GenericArray <Integer> intArray =  new GenericArray<>();
        System.out.println(intArray.length());
        Random rand = new Random();
        for (int i =0; i < 20; i++){
            intArray.add(rand.nextInt(50));
        }
        System.out.println(intArray.length());
        System.out.println(intArray.search(15) ? "Here!" : "Not!");
        intArray.insertionSort();

        intArray.printArray();
        System.out.println();

     Iterator<Integer> iter = intArray.iterator();
     while (iter.hasNext()){
         System.out.print(iter.next() + " ");
     }

      /*  GenericArray <String> StringArray =  new GenericArray<String>();
        StringArray.add("HELLO");
        StringArray.add("WORLD");
        System.out.println(StringArray.length());*/

    }

}
