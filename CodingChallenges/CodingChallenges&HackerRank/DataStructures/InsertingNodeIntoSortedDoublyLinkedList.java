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
    // Write your code here
      DoublyLinkedListNode current = llist;
      
      //EdgeCase #1: the new node will be added 1st
      if(current.prev == null && current.data > data) {
        //System.out.println("Inside E.C.1 if");
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        newNode.next = current;
        current.prev = newNode;
        return newNode;
      }

      while(current != null) {
        //System.out.println("currentNode: " + current.data);
        
        //EdgeCase #2: the new node will be added last
        if(current.next == null && (current.data < data)) {
          //System.out.println("Inside E.C.2 if");
          DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
          newNode.prev = current;
          current.next = newNode;
          return llist;
        } 

        //Regular cases
        if(current.data < data &&
           current.next.data >= data) {
          DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
          newNode.next = current.next;
          current.next.prev = newNode;
          
          newNode.prev = current;
          current.next = newNode;
          return llist;
        }

        current = current.next;
      }
      
      return llist;
    }

}
