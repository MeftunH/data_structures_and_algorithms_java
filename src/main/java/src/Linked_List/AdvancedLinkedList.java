package src.Linked_List;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

public class AdvancedLinkedList {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;
        int size;

        LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        void addFirst(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }

            size++;
        }

        void addLast(int data) {
            Node newNode = new Node(data);

            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            }

            size++;
        }

        void removeFirst() {
            if (head == null) {
                throw new RuntimeException("LinkedList is empty");
            }

            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }

            size--;
        }

        void removeLast() {
            if (tail == null) {
                throw new RuntimeException("LinkedList is empty");
            }

            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }

            size--;
        }

        int get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }

            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current.data;
        }

        void reverse() {
            Node temp = null;
            Node current = head;

            while (current != null) {
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                current = current.prev;
            }

            temp = head;
            head = tail;
            tail = temp;
        }

        void printList() {
            Node current = head;

            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        list.printList();
        list.removeFirst();
        list.removeLast();
        list.printList();
        list.reverse();
        list.printList();
        System.out.println(list.get(1));
    }
}