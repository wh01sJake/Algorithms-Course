package Week8;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();

        try {
            if (fileName.startsWith("  ")){
                throw new FileNameException("File name should not start with '  '");
            }
            else if(!fileName.endsWith(".csv")){
                int length = fileName.length();
                throw new FileNameException("File name should end with '.csv' " + fileName.substring(length -4));
            }
        } catch (FileNameException e) {
            throw new RuntimeException(e);
        }
    }
}
