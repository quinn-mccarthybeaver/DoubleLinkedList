
public class DoublyLinkedList {

    private Node front;     // first element in the list
    private Node current;   // current element in the list
    private Node last;      // last element in the list
    private int size;       // number of elements in the list

    // post: constructs an empty list
    public DoublyLinkedList() {
        front = current = last = null;
        size                   = 0;
    }

    // post: constructs a list with data in first element and "list" after that
    public DoublyLinkedList(int data, DoublyLinkedList list) {
        front      = new Node(data);
        current    = front;
        front.next = list.front;
        last       = list.last;
        size       = list.size + 1;
    }

    // post: returns the integer at the given index in the list
    public int get(int index) {
        checkIndex(index);
        return nodeAt(index).data;
    }

    // post: returns the position of the first occurrence of the given value (-1 if not found)
    public int indexOf(int value) {
        int index    = 0;
        Node current = front;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        last.next = new Node(value);
        last      = last.next;
        size++;
    }

    // post: removes value at the given index
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            front = front.next;
        } else {
            Node current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // post: returns a reference to the node at the given index
    private Node nodeAt(int index) {
        checkIndex(index);
        Node current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // checks if index is out of bound and if it is throws IndexOutOfBoundsException
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    // post: creates a comma-separated, bracketed version of the list
    @Override
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            Node current  = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // Node inner class containing the data, and next and previous references
    private static class Node {
        Node previous;
        int data;
        Node next;

        // constructor to create a Node with data and null previous and next references
        public Node(int data) {
            this.previous = this.next = null;
            this.data                 = data;
        }

        // constructor to add a new Node with data before another its "next" node
        public Node(int data, Node next) {
            this.previous = null;
            this.data     = data;
            this.next     = next;
        }

        // constructor to initialize a new Node with data between its "previous" and "next" node
        public Node(Node previous, int data, Node next) {
            this.previous = previous;
            this.data     = data;
            this.next     = next;
        }
    }
}
