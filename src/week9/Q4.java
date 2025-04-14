package week9;

import Week8Lab.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Q4
 * Description:
 * Write a program that creates a car object from our quiz.
 * Make this car instantiable class serializable and save a serialized file containing
 * all the cars from car.csv, call this “cars.dat”.
 * Datetime: 2025/4/3 11:53
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Q4 {
    public static void main(String[] args) {

        try(FileOutputStream fos = new FileOutputStream("cars.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            BufferedReader br = new BufferedReader(new FileReader("cars.csv"));){
            List<Car> cars = new ArrayList<>();
            br.readLine();

            String line = null;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String color = data[4];
                int price = Integer.parseInt(data[5]);

                cars.add(new Car(id, year, make, model, color, price));
            }


            oos.writeObject(cars);



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
