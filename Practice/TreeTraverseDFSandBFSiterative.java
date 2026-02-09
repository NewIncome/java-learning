import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *        Tree
 *         1
 *        / \
 *       2   3
 *      / \
 *     4   5
 * 
 * >>>  DFS — Depth First Search  <<<
 *   DFS behaves like a stack:
 *     Go deeper → remember 'where' to 'return' → 'continue'
 * 
 * Traversal styles
 * • Preorder  → Root → Left → Right    : 1 2 4 5 3         . "visit early"
 * • Inorder   → Left → Root → Right    : 4 2 5 1 3         . "visit middle"
 * • Postorder → Left → Right → Root    : 4 5 2 3 1         . "visit last"
 * 
 * >>>  BFS — Breadth First Search  <<<
 *   Explore level by level
 *   BFS behaves like a queue:
 *     'First' discovered → 'first' processed
 * 
 * Traversal styles => Order
 * • 1 → 2 → 3 → 4 → 5        : "Process nodes in discovery order"
 */
public class TreeTraverseDFSandBFSiterative {

  static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

  // ========================
  // Iterative Preorder DFS
  // Root → Left → Right
  // ========================
  static void preorder(Node root) {
      if (root == null) return;

      Stack<Node> stack = new Stack<>();
      stack.push(root);

      while (!stack.isEmpty()) {
          Node node = stack.pop();
          System.out.print(node.val + " ");

          if (node.right != null) stack.push(node.right);
          if (node.left != null) stack.push(node.left);
      }
  }

  // ========================
  // Iterative Inorder DFS
  // Left → Root → Right
  // ========================
  static void inorder(Node root) {
      Stack<Node> stack = new Stack<>();
      Node curr = root;

      while (curr != null || !stack.isEmpty()) {
          while (curr != null) {
              stack.push(curr);
              curr = curr.left;
          }

          curr = stack.pop();
          System.out.print(curr.val + " ");
          curr = curr.right;
      }
  }

  // ========================
  // Iterative Postorder DFS
  // Left → Right → Root
  // ========================
  static void postorder(Node root) {
      if (root == null) return;

      Stack<Node> stack1 = new Stack<>();
      Stack<Node> stack2 = new Stack<>();

      stack1.push(root);

      while (!stack1.isEmpty()) {
          Node node = stack1.pop();
          stack2.push(node);

          if (node.left != null) stack1.push(node.left);
          if (node.right != null) stack1.push(node.right);
      }

      while (!stack2.isEmpty()) {
          System.out.print(stack2.pop().val + " ");
      }
  }

  // ========================
  // BFS (Level Order)
  // ========================
  static void bfs(Node root) {
      if (root == null) return;

      Queue<Node> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
          Node node = queue.poll();
          System.out.print(node.val + " ");

          if (node.left != null) queue.offer(node.left);
          if (node.right != null) queue.offer(node.right);
      }
  }


  // ========================
    // Demo
    // ========================
    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Preorder DFS: ");
        preorder(root);

        System.out.print("\nInorder DFS: ");
        inorder(root);

        System.out.print("\nPostorder DFS: ");
        postorder(root);

        System.out.print("\nBFS Level Order: ");
        bfs(root);
    }
    /*
      Preorder DFS: 1 2 4 5 3
      Inorder DFS: 4 2 5 1 3
      Postorder DFS: 4 5 2 3 1
      BFS Level Order: 1 2 3 4 5
     */

}
