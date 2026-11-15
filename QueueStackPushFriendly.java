
import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public QueueStackPushFriendly() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int value) {
        queue1.offer(value);
        System.out.println(value + " pushed onto stack.");
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        int removed = queue1.poll();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return removed;
    }

    public int peek() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        int top = queue1.peek();

        queue2.offer(queue1.poll());

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public int size() {
        return queue1.size();
    }

    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack size: " + stack.size());
    }
}
