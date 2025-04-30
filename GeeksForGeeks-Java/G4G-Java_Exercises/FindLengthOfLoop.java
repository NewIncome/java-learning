/**
 * Given the head of a linked list, determine whether the list contains a loop.
 * If a loop is present, return the number of nodes in the loop, otherwise return 0.
 */
import java.util.ArrayList;
import java.util.StringTokenizer;
//{ Driver Code Starts
import java.io.*;

class Node {
    int data;
    Node next;

    Node(int x) {
      data = x;
      this.next = null;
    }
    Node(int x, Node next) {
        data = x;
        this.next = next;
    }
}

public class FindLengthOfLoop {
    /* //Unusable G4G page code to test the code
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0) return;

        Node curr = head;
        for (int i = 1; i < x; i++) curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int k = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            makeLoop(head, tail, k);

            Solution ob = new Solution();
            System.out.println(ob.countNodesinLoop(head));

            System.out.println("~");
        }
    }*/
    public static Node makeLinkedList(int[] values) {
      return makeLinkedList(values, 0);
    }
    public static Node makeLinkedList(int[] values, int tail) {
      Node head = new Node(values[0]);
      Node currentNode = head;
      Node nodeLoop = new Node(0);

      for(int i = 1; i < values.length; i++) {
        currentNode.next = new Node(values[i]);
        currentNode = currentNode.next;
        if(tail != 0) {
          if(i == (tail - 1)) nodeLoop = currentNode;
          if(i == (values.length - 1)) {
            currentNode.next = nodeLoop;
            System.out.println("Defining last node");
            System.out.println("currentNode: " + currentNode.data);
            System.out.println("currentNode.next.data: " + currentNode.next.data);
          }
        }
      }
      return head;
    }

    public static void printLL(Node head, int size) {
      Node currentNode = head;

      System.out.print("[");
      while(size > 0) {
        System.out.print(currentNode.data + " ");
        currentNode = currentNode.next;
        size--;
      }
      System.out.println("]");
    }

    public static void main(String[] args) {
      int[] arr1 = new int[]{4,2,1,5,8,3};
      makeCountPrintSolution(arr1, 1, 0);

      int[] arr2 = new int[]{25,14,19,33,10,21,39,90,58,45};
      makeCountPrintSolution(arr2, 2, 4);

      int[] arr3 = new int[]{0,1,2,3};
      makeCountPrintSolution(arr3, 3, 0);
    }

    public static void makeCountPrintSolution(int[] arr, int num, int tail) {
      Node hd = makeLinkedList(arr);
      printLL(hd, arr.length);
      int sol = Solution.countNodesinLoop(hd);
      System.out.println("Solution " + num + ": " + sol + "\n");
    }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

/* My solution
 * Totally not working... , no idea what's wrong
class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // code here.
        ArrayList<Integer> arrList = new ArrayList<>();
        int nodeData;
        int l1 = 0;
        
        Node node = head;
        System.out.println("Working??");
        while(node.next != null) {
            arrList.add(node.data);
            System.out.println("Inside 1st While");
            System.out.println("node.data: " + node.data + " :: " + node.next);
            if(arrList.contains(node.data)) {
                System.out.println("Inside If");
                System.out.println("arrList: " + arrList);
                nodeData = node.data;
                while(node.next.data != nodeData) {
                    System.out.println("Inside 2nd While, inner");
                    System.out.println("l1: " + l1);
                    l1++;
                    node = node.next;
                }
                return l1;
            }
            node = node.next;
        }
        System.out.println(head);
        return 0;
    }
}
*/
 
//Solution:
class Solution {
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
