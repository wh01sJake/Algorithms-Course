package Week10.searcher;

/**
 * ClassName: SeacherTest
 * Description:
 * <p>
 * Datetime: 2025/4/8 21:24
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class SearcherTest {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        Found share = new Found();

        Searcher searcher = new Searcher(data,18,(data.length/2)-1,0,share);
        Searcher searcher1 = new Searcher(data,18,data.length-1,(data.length/2),share);


        searcher.start();
        searcher1.start();
        try {
            searcher.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            searcher1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(  share.isFound() ? "Found it!" : "Not Found");



    }
}
