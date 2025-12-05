/**
 * Given pointers to the heads of two sorted linked lists, merge them
 * into a single, sorted linked list. Either head pointer may be null
 * meaning that the corresponding list is empty.
 * • Input
 *  ♦ SinglyLinkedListNode pointer headA: a reference to the head of a list
 *  ♦ SinglyLinkedListNode pointer headB: a reference to the head of a list
 * • Return
 *  ♦ SinglyLinkedListNode pointer: a reference to the head of the merged list
 * • Constraints
 *  ♦ 1 <= t <= 10
 *  ♦ 1 <= n,m <= 1000
 *  ♦ 1 <= list[i] <= 1000, hwere list[i] is the i^th element of the list
 * • Example
 *  ♦ head1 = 1 -> 3 -> 7 -> null, head2 = 1 -> 2 -> null  //1 -> 1 -> 2 -> 3 -> 7 -> null
 * • TestCases
 *  ♦ head1 = 1 -> 2 -> 3, head2 = 3 -> 4        //1 -> 2 -> 3 -> 3 -> 4
 *  ♦ head1 = 4 -> 5 -> 6, head2 = 1 -> 2 -> 10  //1 -> 2 -> 4 -> 5 -> 6 -> 10
 */
public class MergeTwoSortedLinkedLists {

  public static void main(String[] args) {
    //TestCase #1
    //Create LinkedList 1
    SinglyLinkedList llist1 = new SinglyLinkedList();
    llist1.insertNode(4);
    llist1.insertNode(5);
    llist1.insertNode(6);
    System.out.print("LL1: "); SinglyLinkedList.printList(llist1.head);
    //Create LinkedList 2
    SinglyLinkedList llist2 = new SinglyLinkedList();
    llist2.insertNode(1);
    llist2.insertNode(2);
    llist2.insertNode(10);
    System.out.print("LL2: "); SinglyLinkedList.printList(llist2.head);

    System.out.print("LLmerged: "); SinglyLinkedList.printList(mergeLists(llist1.head, llist2.head));
    System.out.println();

    //TestCase #2
    //Create LinkedList 1
    SinglyLinkedList llist3 = new SinglyLinkedList();
    llist3.insertNode(1);
    llist3.insertNode(3);
    llist3.insertNode(7);
    System.out.print("LL1: "); SinglyLinkedList.printList(llist3.head);
    //Create LinkedList 2
    SinglyLinkedList llist4 = new SinglyLinkedList();
    llist4.insertNode(1);
    llist4.insertNode(2);
    System.out.print("LL2: "); SinglyLinkedList.printList(llist4.head);

    System.out.print("LLmerged: "); SinglyLinkedList.printList(mergeLists(llist3.head, llist4.head));
  }

  static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    /* • Assume: never both will be null, at start
     * check:
     * ○ case: if h1 && h2 != null
     * ○ ..do the comparison and update mList..
     * ○ case: h1 == null
     * ○ case: h2 == null
     */
    SinglyLinkedListNode head = null;
    SinglyLinkedListNode current = null;

    if(head1 != null && head1.data <= head2.data) {
      head = head1;
      head1 = head1.next;
    } else {
      head = head2;
      head2 = head2.next;
    }
    current = head;

    //int i=0;

    while(head1 != null || head2 != null) {
      //System.out.println("InsideWhile");
      if(head1 == null) {
        current.next = head2;
        return head;
      }
      if(head2 == null) {
        current.next = head1;
        return head;
      }
      
      //comparison
      if(head1.data <= head2.data) {
        current.next = head1;
        head1 = head1.next;
      } else {
        current.next = head2;
        head2 = head2.next;
      }
      current = current.next;
      //i++;
      //System.out.println("i: " + i);
      //System.out.print("current: "); SinglyLinkedList.printList(current);
      //System.out.print("head:    "); SinglyLinkedList.printList(head);
      //if (i > 15) break;
    }
    
    return head;
  }


  //SinglyLinkedList classes
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
        //System.out.println("head: " + head);
        if(head.next != null) System.out.print(" -> ");
        head = head.next;
        //System.out.println("head.data: " + head.data);
        //System.out.println("head.next: " + head.next);
      }
      System.out.println();
    }
  }

}
