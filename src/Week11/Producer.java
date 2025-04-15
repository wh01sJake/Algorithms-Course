package Week11;

import java.util.function.Consumer;

public class Producer implements Runnable {
    Buffer q;


    public Producer(Buffer q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                q.write("Written by Producer " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
