// Node class
class Node {
  int data; // Data stored in the node
  Node next; // Reference to the next node

  // Constructor
  Node(int data) {
      this.data = data;
      this.next = null;
  }
}

// LinkedList class
class LinkedList {
  Node head; // Head of the list

  // Constructor
  LinkedList() {
      this.head = null;
  }

  // Method to create a linked list with a loop
  public void createLoop(int loopPosition) {
      if (head == null || loopPosition <= 0) {
          return; // Nothing to do if the list is empty or loop position is invalid
      }

      Node current = head;
      Node loopNode = null;
      int count = 1;

      // Traverse to the loop position to find the node where the loop will start
      while (current.next != null && count < loopPosition) {
          current = current.next;
          count++;
      }

      if (count != loopPosition) {
          return; // Loop position is out of bounds
      }

      loopNode = current; // Node where the loop will start

      // Traverse to the end of the list
      while (current.next != null) {
          current = current.next;
      }

      current.next = loopNode; // Create the loop by pointing the last node to loopNode
  }

  // Method to detect a loop in the linked list (Floyd's Cycle-Finding Algorithm)
  public boolean hasLoop() {
      if (head == null) {
          return false; // Empty list has no loop
      }

      Node slow = head;
      Node fast = head;

      while (fast != null && fast.next != null) {
          slow = slow.next; // Move one step
          fast = fast.next.next; // Move two steps

          if (slow == fast) {
              return true; // Loop detected
          }
      }

      return false; // No loop found
  }

  // Method to add a node to the end of the list
  public void append(int data) {
      Node newNode = new Node(data);
      if (head == null) {
          head = newNode;
          return;
      }

      Node current = head;
      while (current.next != null) {
          current = current.next;
      }
      current.next = newNode;
  }

  // Method to display the list
  public void display() {
      Node current = head;
      while (current != null) {
          System.out.print(current.data + " ");
          current = current.next;
      }
      System.out.println();
  }
}

// Main class for testing
public class LinkedListWithLoop {
  public static void main(String[] args) {
      LinkedList list = new LinkedList();

      // Add some nodes
      list.append(1);
      list.append(2);
      list.append(3);
      list.append(4);
      list.append(5);

      System.out.print("Original List: ");
      list.display(); // Output: 1 2 3 4 5

      // Create a loop (e.g., at position 2, which is the node with data 2)
      list.createLoop(2);

      // Check for a loop
      if (list.hasLoop()) {
          System.out.println("The linked list contains a loop.");
      } else {
          System.out.println("The linked list does not contain a loop.");
      }
  }
}
