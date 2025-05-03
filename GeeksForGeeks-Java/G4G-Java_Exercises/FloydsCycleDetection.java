/**
 * Challenge - Find Length of Loop
 * Given the head of a linked list, determine whether the list contains a loop.
 * If a loop is present, return the number of nodes in the loop, otherwise return 0.
 */
public class FloydsCycleDetection {
  // Function to count the number of nodes in loop
  // using Floyd's Cycle Detection Algorithm
  public static int countNodesinLoop(Node head) {
    Node meetPoint = findMeetingPoint(head);
    return countLoopLength(meetPoint);
  } //end countNodesinLoop

  public static int countLoopLength(Node meetingPoint) {
    int count = 1;
    Node current = meetingPoint.next;

    while(current != meetingPoint) {
      count++;
      current = current.next;
    }

    return count;
  } //end countLoopLength

  public static Node getLoopHeadNode(Node head) {
    Node pointer1 = head;
    Node pointer2 = findMeetingPoint(head);

    while(pointer1 != pointer2) {
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;

      if(pointer1 == pointer2) {
        return pointer1;
      }
    }

    return null;
  }

  public static Node findMeetingPoint(Node head) {
    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast) {
        return slow;
      }
    }

    return null;
  }
}

/*
 * Solution is correct, but the way to test the solution,
 * the prev-code to test Solution class is not working
 */
/**
 * Floyd's Cycle Detection Algorithm
 * ---------------------------------
 *  => To find if there is a loop
 *    Make pointer1(Tortoise) traverse the LList by 1
 *    make pointer2(Hare) traverse the LList by 2
 *    If they meet there is a loop,
 *    if any arrive at null there is No loop
 *  => To find the length of the loop
 *    After they meet 1st time(meeting-node)
 *    Make both pointer traverse again from there,
 *    same speed, when they meet again, the times they traverse,
 *    is the length of the loop
 *  => To find the head-node of the loop
 *    One pointer stays in the meeting-node(say Tortoise)
 *    The other moves to the head-ndoe(say Hare)
 *    They both traverse again, but both at same rithm(by 1)
 *    When they meet again, that is the head-node of the loop
 */