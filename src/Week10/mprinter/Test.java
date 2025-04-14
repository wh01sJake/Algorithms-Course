package Week10.mprinter;

/**
 * ClassName: Test
 * Description:
 * <p>
 * Datetime: 2025/4/8 21:17
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Mprinter mp1 = new Mprinter("First printer here");
        Mprinter mp2 = new Mprinter("Second printer here");

        mp1.start();
        mp2.start();

    }
}
