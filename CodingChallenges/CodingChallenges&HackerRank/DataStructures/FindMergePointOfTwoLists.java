import utility.SinglyLinkedListNode;

/**
 * -This challenge is part of a tutorial track by MyCodeSchool-
 * Given pointers to the head nodes of  linked lists that merge together at
 * some point, find the node where the two lists merge. The merge point is
 * where both lists point to the same node, i.e. they reference the same
 * memory location. It is guaranteed that the two head nodes will be different,
 * and neither will be NULL. If the lists share a common node, return that
 * node's  value.
 * Note: After the merge point, both lists will share the same node pointers.
 * 
 * • Example
 *  In the diagram below, the two lists converge at Node x:
      [List #1] a--->b--->c
                          \
                            x--->y--->z--->NULL
                          /
          [List #2] p--->q
 * 
 * • Input
 *  ♦ SinglyLinkedListNode pointer head1: a reference to the head of the first list
 *  ♦ SinglyLinkedListNode pointer head2: a reference to the head of the second list
 * 
 * • Returns
 *  ♦ int: the data value of the node where the lists merge
 * 
 * • Constraints
 *  ♦ The lists will merge:
 *    ○ head1, head2 != null
 *    ○ head1 != head2
 * 
 * • TestCases
 *  ♦ 
        1
          \
          2--->3--->NULL
          /
        1
    ♦ 
        1--->2
              \
              3--->Null
              /
            1
 */
public class FindMergePointOfTwoLists {

  public static void main(String[] args) {
  }

  static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode compareNode = head2;
      
    while(head1 != null) {
      
      while(compareNode != null) {
        if(head1 == compareNode) return compareNode.data;
        compareNode = compareNode.next;
      }
      
      head1 = head1.next;
      compareNode = head2;
    }
    
    return 0;
  }

}
