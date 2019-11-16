package adt;

@SuppressWarnings("WeakerAccess")
public class ArrayQueue<T> implements Queue<T> {

    private Object[] queue;
    private int front, rear;


    /**
     * Erstellt ein neues Queue Objekt mit der angegebenen Grösse.
     *
     * @param initialCapacity initiale Kapazität
     */
    public ArrayQueue(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException
                    ("initialCapacity must be >= 1");
        queue = new Object[initialCapacity + 1];
    }

    /**
     * Erstellt eine neue Queue mit der initialen Kapazität von 10.
     */
    public ArrayQueue() {
        this(10);
    }

    // methods

    /**
     * Liefert den Wert true, wenn die Datenstruktur leer ist.
     *
     * @return true, wenn die Queue leer ist
     */
    @Override
    public boolean isEmpty() {
        return front == rear;
    }


    /**
     * Liefert das vorderes Element der Queue.
     *
     * @return null, wenn die Queue leer ist
     */
    @Override
    @SuppressWarnings("unchecked")
    public T getFrontElement() {
        if (isEmpty())
            return null;
        else
            return (T) queue[(front + 1) % queue.length];
    }

    /**
     * Liefert das letzte Element der Datenstruktur.
     *
     * @return null, wenn die Queue leer ist
     */
    @Override
    @SuppressWarnings("unchecked")
    public T getRearElement() {
        if (isEmpty())
            return null;
        else
            return (T) queue[rear];
    }

    /**
     * Fügt ein neues Element hinten an.
     *
     * @param payload einzufügendes Objekt
     */
    @Override
    public void put(T payload) {

        // Vergrössert (verdoppelt) die Queue, falls notwendig
        if ((rear + 1) % queue.length == front) {
            Object[] newQueue = new Object[2 * queue.length];

            // Umkopieren der elemente
            int start = (front + 1) % queue.length;
            if (start < 2)
                // no wrap around
                System.arraycopy(queue, start, newQueue, 0, queue.length - 1);
            else {  // queue wraps around
                System.arraycopy(queue, start, newQueue, 0, queue.length - start);
                System.arraycopy(queue, 0, newQueue, queue.length - start, rear + 1);
            }

            // Wechseln auf die neue Queue und definieren des ersten und letzten Elementes
            front = newQueue.length - 1;
            rear = queue.length - 2;
            queue = newQueue;
        }

        // Fügt das neue Element hinten in der Queue an
        rear = (rear + 1) % queue.length;
        queue[rear] = payload;
    }

    /**
     * Entfernt das vorderste Elemement aus der Queue.
     *
     * @return null, wenn die Queue leer ist
     */
    @Override
    @SuppressWarnings("unchecked")
    public T remove() {
        if (isEmpty())
            return null;
        front = (front + 1) % queue.length;
        T frontElement = (T) queue[front];
        queue[front] = null;
        return frontElement;
    }

}
