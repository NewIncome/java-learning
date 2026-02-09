/*
     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4  

  In-Order traversal:
    left -> root -> right  |  "visit middle"

  Pseudocode
  + while loop right until null
    + if left != null : while loop left
 */

public class TreeInOrderTraversal {

  public static void main(String[] args) {
    String tree = """
             1
              \\
               2
                \\
                 5
                /  \\
               3    6
                \\
                 4  
        """;
    System.out.println("TestCase tree:");
    System.out.println(tree);
    
    Node root = new Node(1);
    root.right = new Node(2);
    root.right.right = new Node(5);
    root.right.right.left = new Node(3);
    root.right.right.right = new Node(6);
    root.right.right.left.right = new Node(4);

    inOrderRecursion(root);
  }


  public static void inOrderRecursion(Node root) {
    if(root == null) return;

    inOrderRecursion(root.left);
    System.out.print(root.data + " ");
    inOrderRecursion(root.right);
  }

  public static void inOrderIterative(Node root) {
    /* const stack = [];
    let curr = root;

    while (curr || stack.length) {
      while (curr) {
        stack.push(curr);
        curr = curr.left;
      }

      curr = stack.pop();
      console.log(curr.val);
      curr = curr.right;
    } */
  }

}

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
