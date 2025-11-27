/**
 * 
 */
public class ReverseALinkedList {

  public static void main(String[] args) {
    //Create LinkedList for TestCase#1
    SinglyLinkedList llist1 = new SinglyLinkedList();
    llist1.insertNode(1);
    llist1.insertNode(2);
    llist1.insertNode(3);
    SinglyLinkedList.printList(llist1.head);
    SinglyLinkedList.printList(reverse(llist1.head));
    System.out.println();

    //Create LinkedList for TestCase#2
    SinglyLinkedList llist2 = new SinglyLinkedList();
    llist2.insertNode(1);
    llist2.insertNode(2);
    llist2.insertNode(3);
    llist2.insertNode(4);
    llist2.insertNode(5);
    SinglyLinkedList.printList(llist2.head);
    SinglyLinkedList.printList(reverse(llist2.head));
  }

  public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
  // Write your code here
    /* loop through list
      * add each node to position 0
      * so the 1st node will be only one to have .next = null
    */
    SinglyLinkedListNode current;
    SinglyLinkedListNode newHead = new SinglyLinkedListNode(llist.data);
    while(llist.next != null) {
      llist = llist.next;
      current = newHead;
      newHead = new SinglyLinkedListNode(llist.data);
      newHead.next = current;
      //SinglyLinkedList.printList(newHead);
    }
    return newHead;
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

    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
      }

      this.tail = node;
    }

    public static void printList(SinglyLinkedListNode head) {
      while(head != null) {
        System.out.print(head.data);
        if(head.next != null) System.out.print(" -> ");
        head = head.next;
      }
      System.out.println();
    }
  }
}
