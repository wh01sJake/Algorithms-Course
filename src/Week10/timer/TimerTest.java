package Week10.timer;

import java.util.Scanner;

/**
 * ClassName: TimerTest
 * Description:
 * <p>
 * Datetime: 2025/4/8 12:30
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class TimerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Timer timer = new Timer();

        System.out.println("Enter to stop");
        timer.start();

        sc.nextLine();

        timer.terminate();
//        if (timer.isAlive()) timer.interrupt();











    }
}
