package Week11;

public class BoundedBufferSimulator {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(3);

        Thread t1 = new Thread(new Producer(buffer));
        Thread t2 = new Thread(new Producer(buffer));
        Thread t3 = new Thread(new Producer(buffer));
        Thread t4 = new Thread(new Producer(buffer));
        Thread t5 = new Thread(new Producer(buffer));
        Thread t6 = new Thread(new Consumer(buffer));
        Thread t7 = new Thread(new Consumer(buffer));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

    }
}
