package src.ds.Linked_List.song;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

public class Playlist {
    private Node head;
    private Node tail;
    private int size;

    public Playlist() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public void addSong(Song song) {
        Node newNode=new Node(song);

        if (head==null) {
            head=newNode;
            tail=newNode;
        } else {
            tail.setNext(newNode);
            tail=newNode;
        }

        size++;
    }

    public void removeSong(int index) {
        if (index<0||index>=size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current=head;
        Node prev=null;

        for (int i=0; i<index; i++) {
            prev=current;
            current=current.getNext();
        }

        if (current==head) {
            head=head.getNext();
        } else if (current==tail) {
            tail=prev;
            tail.setNext(null);
        } else {
            prev.setNext(current.getNext());
        }

        size--;
    }

    public int getTotalDuration() {
        int totalDuration=0;
        Node current=head;

        while (current!=null) {
            totalDuration+=current.getSong().getDuration();
            current=current.getNext();
        }

        return totalDuration;
    }

    // inner class to represent nodes in the linked list
    private class Node {
        private Song song;
        private Node next;

        public Node(Song song) {
            this.song=song;
            this.next=null;
        }

        // getters and setters
        // ...

        public Song getSong() {
            return song;
        }

        public void setSong(Song song) {
            this.song=song;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next=next;
        }
    }
}
