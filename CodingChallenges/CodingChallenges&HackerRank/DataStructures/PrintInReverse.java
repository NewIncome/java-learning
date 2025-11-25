/**
 * Given a pointer to the head of a singly-linked list, print each
 * data value from the reversed list. If the given list is empty,
 * do not print anything.
 * • Input
 *  ♦ SinglyLinkedListNode pointer head: a reference to the head of the list
 * • Returns:Prints
 *  ♦ The data values of each node in the reversed list.
 */
/*
 * Pseudocode
 * ○ traverse the list until null
 * ○ save each value to another List, at the beginning eachone
 * ○ print the newly created list
 */
import java.util.ArrayList;
import java.util.List;

import InsertNodeAtHeadAndDeleteANode.SinglyLinkedListNode;


public class PrintInReverse {

  public static void main(String[] args) {
    
  }

  public static void reversePrint(SinglyLinkedListNode llist) {
    List<Integer> revList = new ArrayList<>();
    SinglyLinkedListNode current = llist;
    
    //save the current list reversed
    while(current != null) {
      revList.add(0, current.data);
      current = current.next;
    }

    //print the reversedList
    for (Integer i : revList) System.out.println(i);
  }

}
