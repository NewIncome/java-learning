/**
 * Delete the node at a given position in a linked list and return
 * a reference to the head node. The head is at position 0. The list
 * may be empty after you delete the node. In that case, return a
 * null value.
 * • Input
 *  ♦ llist: a reference to the head of a list
 *  ♦ int position: the position of the node to remove
 * • Returns
 *  ♦ SinglyLinkedListNode pointer: a reference to the head of the modified list
 * • Constraints
 *  ♦ 1<= n <= 1000
 *  ♦ 1<= list[i] <= 1000, where list[i] is the i^th element of the linked list.
 * • Example
 *  ♦ llist = 0->1->2->3, position = 2   //0->1->3
 * • TestCases
 *  ♦ llist = 20->6->2->19->7->4->5->9, position = 3   //20->6->2->7->4->5->9
 */
public class InsertNodeAtHeadAndDeleteANode {

  public static void main(String[] args) {
  }

  static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
    if (llist == null) {
      return new SinglyLinkedListNode(data);
    } else {
      SinglyLinkedListNode head = new SinglyLinkedListNode(data);
      head.next = llist;
      return head;
    }
  }

  public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
    //EdgeCase#1: head is null
    if(llist.next == null) return null;
    
    //EdgeCase#2: position to delete is head(0)
    if(position == 0) {
      return llist.next;
    } 

    SinglyLinkedListNode current = llist;
  
    //traverse the list
    while(current != null && position > 1) {
      current = current.next;
      position -= 1;
    }
    //delete the node from the list, not from memory
    current.next = current.next.next;
    
    return llist;
  }



  static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }
  }
  
}
