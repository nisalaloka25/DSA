import java.util.NoSuchElementException;
import java.util.Stack;

/*
 * Concept: Queue implementation using two stacks optimized for dequeue.
 * Time Complexity: Enqueue: O(n), Dequeue: O(1), Peek: O(1)
 * Space Complexity: O(n) auxiliary space
 */

public class StackQueueDequeueFriendly {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public StackQueueDequeueFriendly() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    // Enqueue operation: O(n) - shift elements to enqueueStack, push new item, move back to dequeueStack
    public void enqueue(int x) {
        while (!dequeueStack.isEmpty()) {
            enqueueStack.push(dequeueStack.pop());
        }

        enqueueStack.push(x);

        while (!enqueueStack.isEmpty()) {
            dequeueStack.push(enqueueStack.pop());
        }
    }

    // Dequeue operation: O(1) - directly pop from dequeueStack
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow: Cannot dequeue from an empty queue.");
        }
        return dequeueStack.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow: Cannot peek an empty queue.");
        }
        return dequeueStack.peek();
    }

    public boolean isEmpty() {
        return dequeueStack.isEmpty();
    }

    public int size() {
        return dequeueStack.size();
    }

    public static void main(String[] args) {
        StackQueueDequeueFriendly queue = new StackQueueDequeueFriendly();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element (peek): " + queue.peek()); // 10
        System.out.println("Dequeued: " + queue.dequeue());           // 10
        System.out.println("Dequeued: " + queue.dequeue());           // 20
        System.out.println("Remaining size: " + queue.size());        // 1
    }
}
