package Week10;

/**
 * ClassName: Test
 * Description:
 * <p>
 * Datetime: 2025/4/8 11:36
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Test {
    public static void main(String[] args) {

        HelloThread thread = new HelloThread();
        thread.start();
    }



}



class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello World");
    }
}
