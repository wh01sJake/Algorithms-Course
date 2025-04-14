import java.lang.*;
public class Test01 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(SumN2(1000000l));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime);
        long elapsedTime = (endTime - startTime);
        System.out.println(elapsedTime);
    }

    public static long SumN1(long n) {
        long s = n * ( n + 1)/2;
        return s;
    }


    public static long SumN2(long n) {
        long s = 0;
        for (int j = 0; j < n; j++) {
            s = s + (j+1);
        }
        return s;
    }
}
