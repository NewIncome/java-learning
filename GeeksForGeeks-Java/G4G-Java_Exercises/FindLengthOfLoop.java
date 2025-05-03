/**
 * Code Challenge - Find length of Loop
 * 
 * Given the head of a linked list, determine whether the list contains a loop.
 * If a loop is present, return the number of nodes in the loop, otherwise return 0.
 */
/*
 * Code to test if my solution with Floyd's Cycle Detection Algorith works
 * 
 * Files/Classes needed:
 * • FloydsCycleDetection
 * • LinkedListWithLoop
 */

 class FindLengthOfLoop {
  public static void main(String[] args) {
    LinkedList list1 = new LinkedList(); //make LinkedList
    int[] values1 = new int[]{4,2,1,5,8,3}; //make test values array
    addValuesToList(list1, values1); //add test values
    numberOfNodesIfAny(list1); //count nodes if there's a loop

    LinkedList list2 = new LinkedList();
    int[] values2 = new int[]{0,1,2,3};
    addValuesToList(list2, values2);
    numberOfNodesIfAny(list2);

    LinkedList list3 = new LinkedList();
    int[] values3 = new int[]{25,14,19,33,10,21,39,90,58,45};
    addValuesToList(list3, values3);
    list3.createLoop(4); //add loop to LinkedList, loop length:7
    numberOfNodesIfAny(list3);
    printLoopHeadNode(list3);
    
    LinkedList list4 = new LinkedList();
    int[] values4 = new int[]{1,2,3,4,5};
    addValuesToList(list4, values4);
    list4.createLoop(2); //loop length:7
    numberOfNodesIfAny(list4);
    printLoopHeadNode(list4);
  }

  static void printLoopHeadNode(LinkedList list) {
    Node headNode = FloydsCycleDetection.getLoopHeadNode(list.head);
    System.out.println("Loop head-node: " + headNode.data);
  }

  static void addValuesToList(LinkedList list, int[] values) {
    for(int val : values) {
      list.append(val);
    }
  }

  static void numberOfNodesIfAny(LinkedList list) {
    if(list.hasLoop()) {
      int nodes = FloydsCycleDetection.countNodesinLoop(list.head);
      System.out.println("Nodes in Loop: " + nodes);
    } else {
      System.out.println("Nodes in Loop: 0");
    }
  }
 }