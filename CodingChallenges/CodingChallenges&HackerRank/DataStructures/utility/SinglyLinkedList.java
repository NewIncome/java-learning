package utility;

public class SinglyLinkedList {
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

    public void insertNode(SinglyLinkedListNode node) {
      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
      }

      this.tail = node;
    }

    public static SinglyLinkedListNode getNode(SinglyLinkedListNode head, int pos) {
      while(pos > 1) {
        head = head.next;
        pos -= 1;
      }
      return head;
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