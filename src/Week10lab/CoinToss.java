package Week10lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ClassName: CoinToss
 * Description:
 * <p>
 * Datetime: 2025/4/10 12:23
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class CoinToss {
    public static void main(String[] args) {
        Coin t1 = new Coin();
        Coin t2 = new Coin();
        Coin t3 = new Coin();
        Coin t4 = new Coin();

        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<Integer> results = t1.getResults();
         int size = results.size();
        System.out.println(size);
         double frequency = (double) results.stream().filter(x -> x == 0).count() / size;

        System.out.println(t1.getName() + " frequency for heads " +  frequency);

    }


}


class Coin extends Thread {

 List<Integer> results = new ArrayList<>();

 Random rand = new Random();

    @Override
    public void run() {
        for (int i = 0; i < 2500; i++) {

            int random = rand.nextInt(2);

            if(random == 0){
                results.add(0);
            }
            else if(random == 1){
                results.add(1);
            }

        }
        
    }

    public List<Integer> getResults() {

        return results;
    }
}
