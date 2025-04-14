package week9;

import java.io.*;

/**
 * ClassName: Q3
 * Description:
 * Create a text file numbers.txt that contains 10 numbers. Write a program that reads the contents of the text file.
 * Calculate the sum of the numbers and writes it to a text file called sum.txt.
 * Datetime: 2025/4/3 11:38
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("numbers.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("sum.txt"))) {

            String line = null;
            int sum = 0;
            while ((line = br.readLine()) != null) {
                sum += Integer.parseInt(line);
            }

            System.out.println(sum);

            bw.write(String.valueOf(sum));




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
