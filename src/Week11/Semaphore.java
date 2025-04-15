package Week11;

public class Semaphore {
    int counter;

    public Semaphore(int counter) {
        this.counter = counter;
    }

    public synchronized void acquire() throws InterruptedException {
        while (counter == 0) {
            wait();
        }

        counter--;
    }

    public synchronized void release() {
        counter++;
        notify();
    }
}
