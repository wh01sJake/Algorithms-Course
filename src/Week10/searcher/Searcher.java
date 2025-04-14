package Week10.searcher;

/**
 * ClassName: Searcher
 * Description:
 * <p>
 * Datetime: 2025/4/8 21:20
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Searcher extends Thread {
    private int[] data;
    private int lowerBound, upperBound;
    private int query;
    private final Found found;


    public Searcher(int[] data, int query, int upperBound, int lowerBound,Found found) {
        this.data = data;
        this.query = query;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.found = found;
    }

    @Override
    public void run() {
        int currentIndex = lowerBound;


        while (currentIndex <= upperBound) {

                    if (found.isFound() || currentIndex > query) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + " searching at index " + (currentIndex));
                    if (data[currentIndex] == query) {
                        synchronized (found) {
                        found.setFound();
                        System.out.println(Thread.currentThread().getName() + " found at index " + currentIndex);
                    }
                }
                currentIndex++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

        }


    }


}
