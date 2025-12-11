/**
 * Given a pointer to the head of a linked list and a specific position, determine
 * the data value at that position. Count backwards from the tail node. The tail
 * is at postion 0, its parent is at 1 and so on.
 */
import java.util.LinkedList;
import utility.SinglyLinkedList;
import utility.SinglyLinkedListNode;

public class GetNodeValFromTailAndRemoveDups {

  public static void main(String[] args) {
    SinglyLinkedList llist1 = new SinglyLinkedList();
    llist1.insertNode(1);
    System.out.println(getNode(llist1.head, 0));

    SinglyLinkedList llist2 = new SinglyLinkedList();
    llist2.insertNode(3);
    llist2.insertNode(2);
    llist2.insertNode(1);
    System.out.println(getNode(llist2.head, 2));

    SinglyLinkedList llist3 = new SinglyLinkedList();
    llist3.insertNode(3);
    llist3.insertNode(2);
    llist3.insertNode(1);
    llist3.insertNode(0);
    System.out.println(getNode(llist3.head, 2));

    System.out.println();

    SinglyLinkedList llist4 = new SinglyLinkedList();
    llist4.insertNode(3);
    llist4.insertNode(3);
    llist4.insertNode(3);
    llist4.insertNode(4);
    llist4.insertNode(5);
    SinglyLinkedList.printList(llist4.head);
    SinglyLinkedList.printList(removeDuplicates(llist4.head));
  }

  public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
    //vars: currentNode
    //Op1
    //loop from head to tail
    //then loop backward n positions/times
    //then print that value
    //Op2
    //Use another DS, loop and save the values there
    //then get the position size-positionFromTail
    SinglyLinkedListNode current = llist;
    LinkedList<Integer> list = new LinkedList<>();
    int pos = 0;

    // to reach the end, and deepClone the list
    while(current != null) {
      list.add(current.data);
      current = current.next;
    }

    pos = list.size() == 1 ? 0 : (list.size() - 1) - positionFromTail;
    
    return list.get(pos);
  }

  public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
  // Write your code here
    SinglyLinkedListNode current = llist;

    while(current != null) {
      //edgeCase, remove last element
      
      while(current.next != null && current.data == current.next.data) {
          current.next = current.next.next;
      }
      current = current.next;
      
    }
    
    return llist;
  }

}
