package myPackage;

public class DoublyLinkedList<T> {

    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    //Part 1 Methods

    // addFirst: insert at beginning
    // Time: O(1) – constant pointer updates
    // Space: O(1) – only one new node
    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // addLast: insert at end
    // Time: O(1)
    // Space: O(1)
    public void addLast(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // removeFirst: remove head
    // Time: O(1)
    // Space: O(1)
    public T removeFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        T value = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return value;
    }

    // removeLast: remove tail
    // Time: O(1)
    // Space: O(1)
    public T removeLast() {
        if (tail == null) {
            throw new IndexOutOfBoundsException();
        }
        T value = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return value;
    }

    // insertAtIndex: insert at a given index
    // Time: O(n) – need to traverse to the index
    // Space: O(1)
    public void insertAtIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node newNode = new Node(data);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    // deleteAtIndex: delete node at index
    // Time: O(n) – need to traverse to the index
    // Space: O(1)
    public T deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        T value = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return value;
    }

    // get: retrieve element at index
    // Time: O(n) – traversal
    // Space: O(1)
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // contains: check if value exists
    // Time: O(n) – may traverse whole list
    // Space: O(1)
    public boolean contains(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // size: return current size
    // Time: O(1)
    // Space: O(1)
    public int size() {
        return size;
    }

    // reverse: reverse list in-place
    // Time: O(n) – must traverse all nodes
    // Space: O(1)
    public void reverse() {
        Node current = head;
        Node temp = null;
        tail = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    //Part 2: swapNodes with pointer manipulation

    // swapNodes: swap nodes at index1 and index2
    // Time: O(n) – need to traverse to both indices
    // Space: O(1)
    public void swapNodes(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index1 == index2) {
            return;
        }

        if (index1 > index2) {
            int t = index1;
            index1 = index2;
            index2 = t;
        }

        Node node1 = head;
        Node node2 = head;
        for (int i = 0; i < index1; i++) {
            node1 = node1.next;
        }
        for (int i = 0; i < index2; i++) {
            node2 = node2.next;
        }

        boolean adjacent = (node1.next == node2);

        Node prev1 = node1.prev;
        Node next1 = node1.next;
        Node prev2 = node2.prev;
        Node next2 = node2.next;

        if (adjacent) {
            if (prev1 != null) prev1.next = node2;
            node2.prev = prev1;

            node2.next = node1;
            node1.prev = node2;

            node1.next = next2;
            if (next2 != null) next2.prev = node1;
        } else {
            if (prev1 != null) prev1.next = node2;
            if (next1 != null) next1.prev = node2;
            node2.prev = prev1;
            node2.next = next1;

            if (prev2 != null) prev2.next = node1;
            if (next2 != null) next2.prev = node1;
            node1.prev = prev2;
            node1.next = next2;
        }

        if (node1 == head) head = node2;
        else if (node2 == head) head = node1;

        if (node1 == tail) tail = node2;
        else if (node2 == tail) tail = node1;
    }
}