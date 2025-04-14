package week9;

import Week8Lab.Car;

import java.io.*;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Q5
 * Description:
 * Write a program to parse the cars.dat file and print the results to the screen
 * Datetime: 2025/4/3 12:05
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Q5 {
    public static void main(String[] args) {

        try(FileInputStream fis = new FileInputStream("cars.dat");
            ObjectInputStream ois = new ObjectInputStream(fis)){

            Object obj = ois.readObject();


            if (obj instanceof List<?>) {
                List<?> l = (List<?>) obj;
                if (l.getFirst() instanceof Car) {
                    @SuppressWarnings("unchecked")
                    List<Car> cars = (List<Car>) l;
                }
            }




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
