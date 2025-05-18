package TABA;

import java.io.Serializable;
import java.util.Comparator;

/**
 * ClassName: Stock
 * Description:
 * pojo class for stock details
 * Datetime: 16/05/2025 17:59
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Stock implements Serializable {

    private static final long serialVersionUID = 11223L;

    private int stock_no;
    private double product_size;
    private double profit;
    private String product_type;
    private double weight;
    private String product_name;

    public Stock(int stock_no, double product_size, double profit, String product_type, double weight, String product_name) {
        this.stock_no = stock_no;
        this.product_size = product_size;
        this.profit = profit;
        this.product_type = product_type;
        this.weight = weight;
        this.product_name = product_name;
    }

    public Stock() {
    }


    // static method return different comparator based on options
    public static Comparator<Stock> getComparator(int option) {

        switch (option){
            case 1 -> {
                return new Comparator<Stock>() {
                    @Override
                    public int compare(Stock o1, Stock o2) {
                        return Integer.compare(o1.stock_no,o2.stock_no);
                    }
                };
            }
            case 2 -> {
                return new Comparator<Stock>() {
                    @Override
                    public int compare(Stock o1, Stock o2) {
                        return Double.compare(o1.product_size,o2.product_size);
                    }
                };

            }
            case 3 -> {
                return new Comparator<Stock>() {
                    @Override
                    public int compare(Stock o1, Stock o2) {
                        return Double.compare(o1.profit,o2.profit);
                    }
                };

            }

            case 4 -> {
                return new Comparator<Stock>() {
                    @Override
                    public int compare(Stock o1, Stock o2) {
                        return o1.product_type.compareTo(o2.product_type);
                    }
                };

            }

            case 5 -> {
                return new Comparator<Stock>() {
                    @Override
                    public int compare(Stock o1, Stock o2) {
                        return Double.compare(o1.weight,o2.weight);
                    }
                };

            }

            case 6 -> {
                return new Comparator<Stock>() {
                    @Override
                    public int compare(Stock o1, Stock o2) {
                        return o1.product_name.compareTo(o2.product_name);
                    }
                };

            }
            default -> {
                throw new IllegalStateException("Invalid choice");
            }

        }
    }

    public int getStock_no() {
        return stock_no;
    }

    public void setStock_no(int stock_no) {
        this.stock_no = stock_no;
    }

    public double getProduct_size() {
        return product_size;
    }

    public void setProduct_size(double product_size) {
        this.product_size = product_size;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stock_no=" + stock_no +
                ", product_size=" + product_size +
                ", profit=" + profit +
                ", product_type='" + product_type + '\'' +
                ", weight=" + weight +
                ", product_name='" + product_name + '\'' +
                '}';
    }


    
}
