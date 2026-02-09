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
public class TreeTraverseDFSandBFSrecursive {

  static class Node {
    int data;
    Node left, right;

    Node(int v) { data = v; }
  }


  // ========================
  // Recursive BFS-style traversal
  // (level-by-level recursion)
  // ========================
  static int height(Node node) {
    if (node == null) return 0;
    return 1 + Math.max(height(node.left), height(node.right));
  }

  static void printLevel(Node node, int level) {
    if (node == null) return;

    if (level == 1) System.out.print(node.data + " ");

    printLevel(node.left, level - 1);
    printLevel(node.right, level - 1);
  }

  // BFS
  static void traverseBFS(Node root) {
    int h = height(root);

    for (int i = 1; i <= h; i++) {
        printLevel(root, i);
    }
  }

  // ========================
  // Recursive Inorder
  // Left → Root → Right
  // ========================
  static void inorder(Node node) {
      if (node == null) return;

      inorder(node.left);
      System.out.print(node.data + " ");
      inorder(node.right);
  }


  // ========================
  // Demo
  // ========================
  public static void main(String[] args) {
    String tree =  """
                1
               / \\
              2   3
             / \\
            4   5
        """;
    System.out.println("Demo tree:");
    System.out.println(tree);

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    //System.out.print("Recursive PreOrder: ");
    //preorder(root);

    System.out.print("Recursive InOrder: ");
    inorder(root);

    //System.out.print("\nRecursive PostOrder: ");
    //postorder(root);

    System.out.print("\nRecursive BFS: ");
    traverseBFS(root);
  }

}
