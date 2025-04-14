package week9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: Q2
 * Description:
 * Write a program that asks the user to enter 10 names and writes them to a text file called names.txt.
 * The names should be formatted in a numbered list。
 * Datetime: 2025/4/3 11:29
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {


        System.out.println("Enter 10 names");
        Scanner sc = new Scanner(System.in);
        String[] names = new String[10];

        for (int i = 0; i < 10; i++) {
            String name = sc.nextLine();
            names[i] = name;
        }


        try(BufferedWriter bw = new BufferedWriter(new FileWriter("names.txt"))) {

            for (int i = 0; i < 10; i++) {
                bw.write(names[i]);
                bw.newLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
