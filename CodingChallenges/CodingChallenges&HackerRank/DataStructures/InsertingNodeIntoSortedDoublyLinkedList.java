/**
 * Given a reference to the head of a doubly-linked list and an integer, data,
 * create a new DoublyLinkedListNode object having data value data and insert it
 * at the proper location to maintain the sort.
 * • Input
 *  ♦ DoublyLinkedListNode pointer head:  a reference to the head of a doubly-linked list
 *  ♦ int data:  An integer denoting the value of the  field for the DoublyLinkedListNode
 *               you must insert into the list.
 * • Returns
 *  ♦ DoublyLinkedListNode pointer: a reference to the head of the list
 * • Constraints
 *  ♦ 1<= t <= 10
 *  ♦ 1<= n <= 1000
 *  ♦ 1<= DoublyLinkedListNode.data <= 1000
 * • Example
 *  ♦ 
 * • TestCases
 *  ♦ 
 */
import utility.DoublyLinkedListNode;


public class InsertingNodeIntoSortedDoublyLinkedList {

  public static void main(String[] args) {
  }

  public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
    DoublyLinkedListNode current = llist;
      while(current.next != null) {
        if(current.data < data &&
           current.next.data >= data) {
          //insert node == update curr.next and add it to new node
          DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
          newNode.next = current.next;
          newNode.prev = current;
          current.next.prev = newNode;
          current.next = newNode;
          return llist;
        }
        llist = llist.next;
      }
      
      return llist;
  }

}
