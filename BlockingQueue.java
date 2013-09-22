//source http://cs.lmu.edu/~ray/notes/javathreading/


public class BlockingQueue {
    private Object[] data;
    private int head = 0;
    private int tail = 0;
    private int count = 0;
    public Buffer(int capacity) {
        data = new Object[capacity];
    }
    public synchronized void add(Object item) throws InterruptedException {
        while (count == data.length) {wait();}
        data[tail] = item;
        tail = (tail + 1) % data.length;
        count++;
        notifyAll();
    }
    public synchronized Object remove() throws InterruptedException {
        while (count == 0) {wait();}
        Object item = data[head];
        head = (head + 1) % data.length;
        count--;
        notifyAll();
        return item;
    }
    public synchronized int getSize() {
        return count;
    }
}
