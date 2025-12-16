/**
 * A linked list is said to contain a cycle if any node is visited more than once
 * while traversing the list. Given a pointer to the head of a linked list,
 * determine if it contains a cycle. If it does, return 1. Otherwise, return 0.
 * • Input
 *  ♦ SinglyLinkedListNode pointer head: a reference to the head of the list
 * • Return
 *  ♦ int:  if there is a cycle or  if there is not
 * • Constraints
 *  ♦ 0 <= list size <= 1000
 * • Example
 *  ♦ 1 -> 2 -> 3 -> null        //0
 *  ♦ 1 -> 2 -> 3 -> 1 -> null   //1
 * • TestCases
 *  ♦ 1 ->   //0
 *  ♦ 1 -> 2 -> 3 -> 2   //1
 */
import java.util.List;
import java.util.LinkedList;
import utility.SinglyLinkedList;
import utility.SinglyLinkedListNode;


public class CycleDetection {

  public static void main(String[] args) {
    //TestCase #1
    SinglyLinkedList llist1 = new SinglyLinkedList();
    llist1.insertNode(1);
    llist1.insertNode(2);
    llist1.insertNode(3);
    System.out.print("LL1: "); SinglyLinkedList.printList(llist1.head);
    System.out.println(cycleDetection(llist1.head));
    System.out.println();

    //TestCase #2
    SinglyLinkedList llist2 = new SinglyLinkedList();
    llist2.insertNode(1);
    llist2.insertNode(2);
    llist2.insertNode(3);
    llist2.insertNode(SinglyLinkedList.getNode(llist2.head, 1));
    //System.out.print("LL2: "); SinglyLinkedList.printList(llist2.head); //can't do this print with loops
    System.out.println(cycleDetection(llist2.head));
    System.out.println();

    //TestCase #3
    SinglyLinkedList llist3 = new SinglyLinkedList();
    llist3.insertNode(1);
    System.out.print("LL3: "); SinglyLinkedList.printList(llist3.head);
    System.out.println(cycleDetection(llist3.head));
    System.out.println();

    //TestCase #4
    SinglyLinkedList llist4 = new SinglyLinkedList();
    llist4.insertNode(1);
    llist4.insertNode(2);
    llist4.insertNode(3);
    llist4.insertNode(SinglyLinkedList.getNode(llist4.head, 2));
    //System.out.print("LL4: "); SinglyLinkedList.printList(llist4.head);
    System.out.println(cycleDetection(llist4.head));
    System.out.println();
  }

  //with Hare&Tortoise Algorithm
  public static int cycleDetection(SinglyLinkedListNode head) {
    if(head == null) return 0;

    SinglyLinkedListNode slow = head;
    SinglyLinkedListNode fast = head;

    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast) return 1;
    }

    return 0;
  }

  //method for Java LinkedList
  /* public static int cycleDetectionForJavaList(List<Integer> head) {
     if(list.size() < 2) return 0;
      
    List<Integer> revList = new LinkedList<>();
    int current;
    
    Iterator<Integer> iterator = list.iterator();
    
    while(iterator.hasNext()) {
      current = iterator.next();
      if(revList.contains(current)) return 1;
      revList.add(current);
    }
    
    return 0;
  } */
  
}
