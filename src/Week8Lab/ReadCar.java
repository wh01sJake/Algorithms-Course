package Week8Lab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadCar {
    public static void main(String[] args) throws Exception {

        List<Car> cars = new ArrayList<>();

        try(BufferedReader br= new BufferedReader(new FileReader("cars.csv"))){
            br.readLine();


            String line;

            while((line=br.readLine())!=null){
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);

                String make = data[2];

                String model = data[3];

                String color = data[4];

                 int price = Integer.parseInt(data[5]);

                cars.add(new Car(id,year,make,model,color,price));

                Collections.sort(cars);

                for (Car car : cars) {
                    if (car.getYear()<2010 && car.getPrice()>40000){
                        continue;
                    }
                    System.out.println(car);
                }


            }

        }
    }
}
