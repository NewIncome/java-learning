/**
 * You are given the head of a linked list. You have to
 * replace all the values of the nodes with the nearest
 * prime number. If more than one prime number exists at
 * an equal distance, choose the smallest one. Return the
 * head of the modified linked list.
 * T.C.
 * Input: head = 2 → 6 → 10
 * Output: 2 → 5 → 11
 * 
 * Input: head = 1 → 15 → 20
 * Output: 2 → 13 → 19
 */
class Solution {
  public static void main(String[] args) {

  }

  Node primeList(Node head) {
    // code here
    /*
    * Steps:
    * • Traverse the LL, to replace the data with primes
    *   • Check if the number is a prime number (%2,3,5)
    *   • check if more than one prime number exist
    *     • choose the smallest one
    *   • return the head of the modified LL
    */
    Node currentNode = head;
    int val;

    while(currentNode != null) {
      val = currentNode.val;
      
      if(val)
      
      if(val % 2 == 0 && val % 3 == 0) {
          
      } else if(val % 2 == 0 && val % 5 == 0) {
      } else if(val % 3 == 0 && val % 3 == 0) {
      } else {
          if(val % 2 == 0) {
          } else if(val % 3 == 0) {
          } else if(val % 5 == 0) {
          }
      }
      
      currentNode = currenNode.next;
    }
    System.out.println(head.val);
    //return null;
  }
  
  boolean isPrime(int num) {
    if(num % )
  }

  //...
}
