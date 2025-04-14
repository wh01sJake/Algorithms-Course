package Week10lab;

/**
 * ClassName: Q1
 * Description:
 * <p>
 * Datetime: 2025/4/10 12:17
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Q0 {
    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                for (int i = 10; i > 0; i--) {
                    System.out.println(Thread.currentThread().getName() + " " + i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}
