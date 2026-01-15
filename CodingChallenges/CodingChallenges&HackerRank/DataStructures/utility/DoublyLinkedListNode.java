/**
 * Node class to create DoublyLinkedList Nodes for HackerRank coding challenges
 */
package utility;


public static class DoublyLinkedListNode {
  public int data;
  public DoublyLinkedListNode next;
  public DoublyLinkedListNode prev;

  public DoublyLinkedListNode(int nodeData) {
    this.data = nodeData;
    this.next = null;
    this.prev = null;
  }
}
