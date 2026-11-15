
import java.util.Stack;

public class StackQueueEnqueueFriendly {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueueEnqueueFriendly() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value) {

        stack1.push(value);

        System.out.println(value + " added to queue.");
    }

    public int dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int removed = stack2.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return removed;
    }

    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int front = stack2.peek();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return front;
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public int size() {
        return stack1.size();
    }

    public static void main(String[] args) {

        StackQueueEnqueueFriendly queue =
                new StackQueueEnqueueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.enqueue(40);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Queue empty: " + queue.isEmpty());
    }
}
