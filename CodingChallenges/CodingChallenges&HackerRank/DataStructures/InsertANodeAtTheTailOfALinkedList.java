import java.io.BufferedWriter;
import java.io.IOException;

public class InsertANodeAtTheTailOfALinkedList {

  public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();
    
    list.head = new SinglyLinkedListNode(666);

    printLinkedList(insertNodeAtTail(list.head, 1));
    //System.out.println(insertNodeAtTail(list.head, 141));
  }

  static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
      //traverse the array, then .add() when null
      SinglyLinkedListNode currentN = head;
      
      //EdgeCase#1: in case head == nul
      if(head == null) {
        head = new SinglyLinkedListNode(data);
        return head;
      }

      do {
        if(currentN.next == null) {
          currentN.next = new SinglyLinkedListNode(data);
          break;  //needed or else it adds this node infinitely
        }
        //System.out.println("Inside while, nodeData: " + head.data);
        currentN = currentN.next;
      } while(currentN != null);
      
      return head;
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

      public SinglyLinkedList() {
          this.head = null;
      }
  }

  static void printLinkedList(SinglyLinkedListNode head) {
    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }

  /* //HackerRanks way of printing a LinkedList
  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
      while (node != null) {
          bufferedWriter.write(String.valueOf(node.data));

          node = node.next;

          if (node != null) {
              bufferedWriter.write(sep);
          }
      }
  }*/

}
