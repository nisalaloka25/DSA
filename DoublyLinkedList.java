import java.util.NoSuchElementException;

/*
 * Concept: Bidirectional linked list with front and back traversal pointers.
 * Time Complexity: addFirst: O(1), addLast: O(1), removeFirst: O(1), removeLast: O(1)
 * Space Complexity: O(n) for node allocations
 */

public class DoublyLinkedList {
    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty DoublyLinkedList.");
        }
        int data = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty DoublyLinkedList.");
        }
        int data = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void displayForward() {
        Node curr = head;
        System.out.print("Head -> ");
        while (curr != null) {
            System.out.print("[" + curr.data + "] <-> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public void displayBackward() {
        Node curr = tail;
        System.out.print("Tail -> ");
        while (curr != null) {
            System.out.print("[" + curr.data + "] <-> ");
            curr = curr.prev;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(20);
        dll.addFirst(10);
        dll.addLast(30);

        dll.displayForward();  // Head -> [10] <-> [20] <-> [30] <-> NULL
        dll.displayBackward(); // Tail -> [30] <-> [20] <-> [10] <-> NULL

        dll.removeLast();
        dll.displayForward();  // Head -> [10] <-> [20] <-> NULL
    }
}
