package TABA;

import java.io.*;
import java.util.*;

/**
 * ClassName: StockApp
 * Description:
 * provide functions to read/write/sort stock.csv
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

        List<Stock> myStocks = new ArrayList<>(10000);

        parse(myStocks);
/*        for (Stock stock : myStocks){
            System.out.println(stock);
        }*/

//        sortByOption(myStocks);

        // a for loop to start 6 threads
        for (int i = 0; i < 6; i++) {
            // need a new list for each thread to avoid concurrent modifying
            List<Stock> newStocks = new ArrayList<>(myStocks);

            Thread thread = new Thread(new SortThread(newStocks,i+1),"T"+(i+1));
            thread.start();
        }

    }

    // question 1.b
    private static void parse(List<Stock> newStockList) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stock.dat"))) {
            Object stockObj = ois.readObject();

            if (stockObj instanceof List<?> list) {
                parseRecursively(list, 0, newStockList);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void parseRecursively(List<?> list, int index, List<Stock> newStockList) {
        // Base case: if index is out of bounds, stop recursion
        if (index >= list.size()) {
            return;
        }

        if (list.get(index) instanceof Stock stock) {
            newStockList.add(stock);
        }

        parseRecursively(list, index + 1, newStockList);
    }

    // question 1.c
    // to increase the readability of the code I'll create a static method in Stock class to return Comparator based on options.
    private static void sortByOption(List<Stock> list){

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter 1,2,3,4,5 to sort data by stock_no/product_size/profit/product_type/weight/product_name");

        int option = sc.nextInt();

        switch (option){

            case 1 -> list.sort(Stock.getComparator(1));

            case 2 -> list.sort(Stock.getComparator(2));

            case 3 -> list.sort(Stock.getComparator(3));

            case 4 -> list.sort(Stock.getComparator(4));

            case 5 -> list.sort(Stock.getComparator(5));

            case 6 -> list.sort(Stock.getComparator(6));

            default -> throw new IllegalStateException("Invalid option");
        }


    }


}

//Question 1.b
// each thread will sort an already-loaded list based on option
class SortThread implements Runnable{
    private final List<Stock> list;
    private final int option;


    /**
     *
     * @param list  already-loaded stocks list
     * @param option 1-6 for each column
     */
    public SortThread(List<Stock> list, int option) {
        this.list = list;
        this.option = option;
    }

    @Override
    public void run() {

        switch (option){
            case 1 -> list.sort(Stock.getComparator(1));
            case 2 -> list.sort(Stock.getComparator(2));
            case 3 -> list.sort(Stock.getComparator(3));
            case 4 -> list.sort(Stock.getComparator(4));
            case 5 -> list.sort(Stock.getComparator(5));
            case 6 -> list.sort(Stock.getComparator(6));
        }

        String fileName = "sortedStocks_C" + option +".csv";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            // write table header first
            bw.write("stock_no,product_size,profit,product_type,weight,product_name\n");

            StringBuilder sb = new StringBuilder();

            for (Stock stock : list){
//                sb.append(stock.toString());
                sb.append(stock.getStock_no()).append(",");
                sb.append(stock.getProduct_size()).append(",");
                sb.append(stock.getProfit()).append(",");
                sb.append(stock.getProduct_type()).append(",");
                sb.append(stock.getWeight()).append(",");
                sb.append(stock.getProduct_name()).append("\n");
            }

            bw.write(sb.toString());

            System.out.println(Thread.currentThread().getName() + " generated file: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
