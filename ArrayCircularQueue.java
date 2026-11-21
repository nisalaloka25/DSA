import java.util.NoSuchElementException;

/*
 * Concept: Fixed array circular queue with modulo index wrap-around logic.
 * Time Complexity: Enqueue: O(1), Dequeue: O(1), Peek: O(1)
 * Space Complexity: O(N) where N is array capacity
 */

public class ArrayCircularQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int count;
    private int capacity;

    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    // Enqueue using modulo index wrapping
    public void enqueue(int x) {
        if (isFull()) {
            throw new IllegalStateException("Queue Overflow: Circular queue is full.");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        count++;
    }

    // Dequeue using modulo index wrapping
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow: Circular queue is empty.");
        }
        int dequeuedValue = arr[front];
        front = (front + 1) % capacity;
        count--;
        return dequeuedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow: Circular queue is empty.");
        }
        return arr[front];
    }

    public boolean isFull() {
        return count == capacity;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        ArrayCircularQueue cq = new ArrayCircularQueue(3);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);

        System.out.println("Dequeued: " + cq.dequeue()); // 10
        cq.enqueue(40); // Wraps around to index 0

        System.out.println("Front element: " + cq.peek()); // 20
        System.out.println("Is full: " + cq.isFull());     // true
    }
}
