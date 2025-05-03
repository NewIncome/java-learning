/**
 * Challenge - Find Length of Loop
 * Given the head of a linked list, determine whether the list contains a loop.
 * If a loop is present, return the number of nodes in the loop, otherwise return 0.
 */
public class FloydsCycleDetection {
  // Function to count the number of nodes in loop
  // using Floyd's Cycle Detection Algorithm
  public static int countNodesinLoop(Node head) {
    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast) {
        // Loop detected, count the length
        return countLoopLength(slow); 
      }
    }

    return 0;
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
}

/*
 * Solution is correct, but the way to test the solution,
 * the prev-code to test Solution class is not working
 */
/**
 * Floyd's Cycle Detection Algorithm
 * ---------------------------------
 *  => To find if there is a loop
 *    Make pointer1(Tortoise) traverse the loop by 1
 *    make pointer2(hare) traverse the loop by 2
 *    If they meet there is a loop,
 *    if any arrive at null there is No loop
 *  => To find the length of the loop
 *    After they meet 1st time(meeting-node)
 *    Make both pointer loop again from there, same speed,
 *    when they meet again, the times they traverse,
 *    is the length of the loop
 *  => To find the head-node of the loop
 *    One pointer stays in the meeting-node
 *    
 */