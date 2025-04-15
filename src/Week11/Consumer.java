package Week11;

public class Consumer implements Runnable {
    Buffer q;

    public Consumer(Buffer q) {
        this.q = q;
    }


    @Override
    public void run() {
        while (true) {

            try {
                Object read = q.read();

                System.out.println("msg from Consumer "+Thread.currentThread().getName() +" " + read.toString());

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
