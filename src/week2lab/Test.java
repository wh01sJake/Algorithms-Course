package week2lab;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(sum(50));
        System.out.println(sum_const_time(50));
        concatDigits(2);
    }




    public static int sum(int n) {
        int sum = 0;
        if (n >= 0){
            sum = n *(n+1)/2;
        }
        return sum;
    }

    public static int sum_const_time (int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void concatDigits(int n) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                output.append(i);
                output.append(j);
               output.append(",");

            }
        }
        System.out.println(output);
    }

    public static void plateNumber(){
        List<String> results = new ArrayList<>();
        char[] possibleChars = new char[36];  // 26 + 10 =36

        for (int i = 0; i < 26; i++) {
            possibleChars[i] = (char) ('A' + i);
        }

        for (int i = 26; i < 36; i++) {
            possibleChars[i] = (char) ('0' + (i-26));
        }

        for (int i = 0; i < 36; i++) {
            for (int j = 0; j < 36; j++) {
                for (int k = 0; k < 36; k++) {
                    for (int l = 0; l < 36; l++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(possibleChars[i]);
                        sb.append(possibleChars[k]);
                        sb.append(possibleChars[l]);
                        sb.append(possibleChars[l]);
                        results.add(sb.toString());
                    }
                }
            }
        }
        System.out.println(results);

    }



}
