package Week10;

/**
 * ClassName: Test03
 * Description:
 * <p>
 * Datetime: 2025/4/8 11:42
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Test03 {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread t1  =new Thread(runnable);
        t1.start();

    }
}


class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
