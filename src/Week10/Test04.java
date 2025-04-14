package Week10;

import java.util.concurrent.Callable;

/**
 * ClassName: Test04
 * Description:
 * <p>
 * Datetime: 2025/4/8 11:50
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Test04 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable1());
        Thread t2 = new Thread(new MyRunnable2());


        t1.setName("T1");
        t1.start();
        t2.setName("T2");
        t2.start();


    }
}


class MyRunnable1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {

            System.out.println(Thread.currentThread().getName() + " -> " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        for (int i = 100; i >0 ; i--) {

            System.out.println(Thread.currentThread().getName() + " -> " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
