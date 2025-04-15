package Week11;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    Semaphore useQueue;
    Semaphore emptyCount;
    Semaphore fullCount;
    Queue<Object> queue;


    public Buffer(int size) {

        useQueue = new Semaphore(1);
        emptyCount = new Semaphore(size);
        fullCount = new Semaphore(0);
        queue = new LinkedList<>();
    }


    public void write(Object data) throws InterruptedException {

        emptyCount.acquire();

        useQueue.acquire();

        queue.add(data);

        useQueue.release();

        fullCount.release();

    }

    public Object read() throws InterruptedException {
        fullCount.acquire();
        useQueue.acquire();

        Object data = queue.poll();

        useQueue.release();

        emptyCount.release();
        return data;
    }
}
