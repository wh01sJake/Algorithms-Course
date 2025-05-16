package TABA;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: StockApp
 * Description:
 *
 * provide function to read/write/sort/output log from stock.csv
 * Datetime: 16/05/2025 18:07
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class StockApp {
    public static void main(String[] args) {

        List<Stock> stocks = new ArrayList<>();

        String line = null;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stock.dat"));
            BufferedReader br = new BufferedReader(new FileReader("stock.csv"))){

            // skip the first line
            br.readLine();

            while ((line = br.readLine()) != null){
                String[] data = line.split(",");

                int stock_no = Integer.parseInt(data[0]);

                double product_size = Double.parseDouble(data[1]);

                double profit = Double.parseDouble(data[2]);

                String product_type = data[3];

                double weight = Double.parseDouble(data[4]);

                String product_name = data[5];

                stocks.add(new Stock(stock_no,product_size,profit,product_type,weight,product_name));


            }

//            stocks.forEach(System.out::println);

            oos.writeObject(stocks);




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void parse(Object o){

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stock.dat"))){
            Object stockObj = ois.readObject();

            if (stockObj instanceof List<?> list){
                for (Object object : list){
                    if (object instanceof Stock stock){
                        System.out.println(stock);
                    }
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
