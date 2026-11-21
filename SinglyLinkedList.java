import java.util.NoSuchElementException;

/*
 * Concept: Linear collection of nodes connected via single forward pointers.
 * Time Complexity: addFirst: O(1), addLast: O(n), removeFirst: O(1), removeLast: O(n)
 * Space Complexity: O(n) for node allocations
 */

public class SinglyLinkedList {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty SinglyLinkedList.");
        }
        int removedData = head.data;
        head = head.next;
        size--;
        return removedData;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty SinglyLinkedList.");
        }
        if (head.next == null) {
            int data = head.data;
            head = null;
            size--;
            return data;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int data = current.next.data;
        current.next = null;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void display() {
        Node current = head;
        System.out.print("Head -> ");
        while (current != null) {
            System.out.print("[" + current.data + "] -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(20);
        list.addFirst(10);
        list.addLast(30);
        list.display(); // Head -> [10] -> [20] -> [30] -> NULL

        list.removeFirst();
        list.removeLast();
        list.display(); // Head -> [20] -> NULL
    }
}
