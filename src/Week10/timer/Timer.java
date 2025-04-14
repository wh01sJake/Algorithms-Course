package Week10.timer;

/**
 * ClassName: Timer
 * Description:
 * <p>
 * Datetime: 2025/4/8 12:28
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Timer extends Thread {
    int et;
    boolean go ;


    public Timer() {
        et = 1;
        go = true;
    }

    @Override
    public void run() {
        while (et <= 10 && go) {
            System.out.println(Thread.currentThread().getName() + ": " + et);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            et++;

        }

    }

    public void terminate() {
        go = false;
    }
}
