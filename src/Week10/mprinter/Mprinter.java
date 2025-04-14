package Week10.mprinter;

/**
 * ClassName: Mprinter
 * Description:
 * <p>
 * Datetime: 2025/4/8 21:15
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Mprinter extends Thread {
    String message;

    public Mprinter(String message) {
        this.message = message;
    }


    @Override
    public void run() {
        while (true) {

            System.out.println(message);
            Thread.yield();
        }
    }
}
