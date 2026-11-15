
public class UnboundedArrayStack {

    private int[] array;
    private int top;
    private int capacity;

    private static final int INITIAL_CAPACITY = 4;

    public UnboundedArrayStack() {
        capacity = INITIAL_CAPACITY;
        array = new int[capacity];
        top = -1;
    }

    public void push(int value) {

        if (top == capacity - 1) {
            resize(capacity * 2);
        }

        array[++top] = value;

        System.out.println(value + " pushed onto stack.");
    }

    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        int removed = array[top];
        top--;

        if (capacity > INITIAL_CAPACITY &&
                size() <= capacity / 4) {

            resize(Math.max(INITIAL_CAPACITY, capacity / 2));
        }

        return removed;
    }

    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public int getCapacity() {
        return capacity;
    }

    private void resize(int newCapacity) {

        int[] newArray = new int[newCapacity];

        for (int i = 0; i <= top; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
        capacity = newCapacity;

        System.out.println("Array resized to: " + capacity);
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.print("Stack elements: ");

        for (int i = top; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        UnboundedArrayStack stack = new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);

        stack.display();

        System.out.println("Current capacity: "
                + stack.getCapacity());

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        stack.display();

        System.out.println("Current size: " + stack.size());
        System.out.println("Current capacity: "
                + stack.getCapacity());
    }
}
