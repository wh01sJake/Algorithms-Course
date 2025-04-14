package week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * ClassName: Q1
 * Description:
 * <p>
 * Datetime: 2025/4/3 11:22
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) throws IOException {

        System.out.println("Please enter 2 numbers");
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = a + b;

        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))) {

            bufferedWriter.write(sum + "\n");

        }
    }
}
