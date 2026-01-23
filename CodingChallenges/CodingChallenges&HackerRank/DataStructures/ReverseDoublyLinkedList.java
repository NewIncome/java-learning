/**
 * Given the pointer to the head node of a doubly linked list, reverse the order
 * of the nodes in place. That is, change the next and prev pointers of the nodes
 * so that the direction of the list is reversed. Return a reference to the head
 * node of the reversed list.
 * Note: The head node might be NULL to indicate that the list is empty.
 * ۝ Input
 *  ۞ DoublyLinkedListNode head: a reference to the head of a DoublyLinkedList
 * ۝ Return
 *  ۞ DoublyLinkedListNode: a reference to the head of the reversed list
 * ۝ Constraints
 *  ۞ 1 <= t <= 10
 *  ۞ 0 <= n <= 1000
 *  ۞ 0 <= DoublyLinkedListNode.data <= 1000
 * ۝ Example
 *  ۞ llist = 1 <-> 2 <-> 3 <-> 4 -> null   //4 <-> 3 <-> 2 <-> 1 -> null
 * ۝ TestCases
 *  ۞ 4 <-> 3 <-> 2 <-> 1 -> null
 *  ۞ 2 <-> 3 <-> 4 -> null
 *  ۞ 47 <-> 35 <-> 23 <-> 20 <-> 17 -> null
 */
public class ReverseDoublyLinkedList {

  public static void main(String[] args) {
  }

  public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
    DoublyLinkedListNode currentNode = llist;
    DoublyLinkedListNode newHead = llist;  //Needs initialization. No matter if seems redundant, at first.

    while(currentNode != null) {
      DoublyLinkedListNode prev = currentNode.prev;

      currentNode.prev = currentNode.next;
      currentNode.next = prev;
      newHead = currentNode;  //To keep account of the end

      currentNode = currentNode.prev;
    }

    return newHead;
  }

  public static DoublyLinkedListNode reverse0(DoublyLinkedListNode llist) {
  // Write your code here
    //In case list is null
    if(llist == null || llist.next == null) return llist;
    
    /* 1- Save the currentNode
       2- FirstNode invert
           prev = next;
           next = null;
       + change nodes
           llist = currentNode
           currentNode = llist.next
       3- Invert the llist-node
           next = prev;
           prev = current;
       + change nodes
           llist = currentNode
           currentNode = llist.next
       4- LastNode(.next == null) invert
           next = prev;
           prev = null;
    */
    
    //1- Save the currentNode
    DoublyLinkedListNode current = llist.next;
    
    //2- FirstNode invert
    llist.prev = llist.next;
    llist.next = null;
    llist = current;  //change nodes
    current = llist.next;
    
    //3- Invert the llist-node
    while(current != null) {
      llist.next = llist.prev;
      llist.prev = current;
      llist = current;  //change nodes
      current = llist.next;
      if(llist.next != null) System.out.println("- llist.data: " + llist.data + ", llist.next: " + llist.next.data + ", llist.prev: " + llist.prev.data);
      
      //4- LastNode(.next == null) invert
      if(current.next == null) {
        llist.next = llist.prev;
        llist.prev = null;
        if(llist.next != null) System.out.println("InsideIF, llist.next: " + llist.next.data + ", curr.data: " + current.data);
        return llist;
      }
    }
    
    if(llist.next != null) System.out.println("End, llist.next: " + llist.next.data);
    else System.out.println("End, next=null, llist.data: " + llist.data);
    return llist;
  }

}
