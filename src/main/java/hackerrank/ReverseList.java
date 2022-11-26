package hackerrank;

public class ReverseList {
    public static void main(String[] args) {

    }
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode list) {
    DoublyLinkedListNode current = list;
    DoublyLinkedListNode temp;
    //1<=>2<=>3<=>4<=>5
    //5>=>4>=>3>=>2>=>1
        while(current!=null) {
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(current.prev);
            current.setNext(temp);
        }
        return list;
    }
}
