/**
 * Tree for TopView challenge
 *    1
 *     \
 *      2
 *       \
 *        5
 *       /  \
 *      3    6
 *       \
 *        4
 * 
 */
/*
  Pseudocode(TopView)
  + Assumming the tree is ordered descending somehow
  ○ Key Idea: we solve this using BFS (level-order traversal) and track each node's HD
    HoricontalDistance(HD) :  Root -> HD=0, LeftChild -> HD-1, RightChild -> HD+1
  ○ TheRule: For each horizontal distance, we print the first node encountered in level order.
    Because BFS visits nodes level by level, the first node at each HD is the topmost one.
  ○ DataStructures used:
    ◙ Queue → for BFS
    ◙ TreeMap<Integer, Integer> →  Key = HD, Value = node value
      TreeMap keeps keys sorted automatically (so we print left → right)
  
  ***Recursion is standard for DFS, not for BFS
     BFS is inherently iterative
     Recursion uses the call stack, which behaves like a stack (LIFO)
    The magic for this solution is the TreeMap with the key-HD which will not be repeated,
    and it will add the first value which will always be the outer-one,
    because that's how the tree is traversed.
    And because the inner branches will
  
     one last insight
    ***We use a TreeMap<Integer, Integer> instead of a HashMap,
       because it automatically sorts the HD keys, removing the
       need to track minHD and maxHD
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import utility.TreeNode;


public class TreeTopView {

  //Passing solution
  static class Pair {
    TreeNode node;
    int hd;  //horizontal distance

    Pair(TreeNode node, int hd) {
      this.node = node;
      this.hd = hd;
    }

    @Override
    public String toString() {
      return "(nodeData: " + node.data + ", hd: " + hd + ")";
    }

    public String toStringWhole() {
      return "(" +
              "node=" + node.data +
              ", hd=" + hd +
              ", left=" + (node.left != null ? node.left.data : "null") +
              ", right=" + (node.right != null ? node.right.data : "null") +
              ")";  
    }
  }
  public static void topView(TreeNode root) {
    if(root == null) return;

    Queue<Pair> queue = new LinkedList<>();
    TreeMap<Integer, Integer> map = new TreeMap<>();  //<HD, nodeValue>  , tha magic is done by HD-key

    queue.add(new Pair(root, 0));  //initializing the TreeMap

    while(!queue.isEmpty()) {
      Pair current = queue.poll();
      TreeNode node = current.node;
      int hd = current.hd;

      // If this horizontal distance is seen first time
      if(!map.containsKey(hd))
        map.put(hd, node.data);

      if(node.left != null)
        queue.add(new Pair(node.left, hd - 1));
      if(node.right != null)
        queue.add(new Pair(node.right, hd + 1));

      //System.out.println("hd: " + hd + ", current: " + current.toStringWhole() + ", node: " + node.data);
    }

    //print top view
    for (int value : map.values()) {
      System.out.print(value + " ");
    }
  }

  /* //Hindi version
  static class NodeLevel {
    Node node;
    Integer level;
    NodeLevel(Node node, Integer level) {
      this.node = node;
      this.level = level;
    }
  }
  public static void topView(Node root) {
    Queue<NodeLevel> q = new LinkedList<>();
    TreeMap<Integer, Integer> tm = new TreeMap<>();

    if(root == null) return;

    q.add(new NodeLevel(root, 0));
    while (!q.isEmpty()) {
      NodeLevel temp = q.poll();
      Node temp1 = temp.node;
      Integer level = temp.level;

      if(!tm.containsKey(level))
        tm.put(level, temp1.data);
      if(temp1.left != null)
        q.add(new NodeLevel(temp1.left, level-1));
      if(temp1.right != null)
        q.add(new NodeLevel(temp1.right, level+1));
    }

    for(Map.Entry<Integer, Integer> e : tm.entrySet()) {
      System.out.print(e.getKey() + " ");
    }
  } */

  /* public static void topViewRecursivePYcode(Node root, int key,
                                      int level, Map<Integer,
                                      ArrayList<Integer>> mappedLevels) {
    if(root == null) return;

    //if key is not present in the hashMap
    if(!mappedLevels.containsKey(key))
      mappedLevels.put(root, level);
    //if key is present in the hashMap
    else if(mappedLevels.get(key).get(0))
      mappedLevels.put(root, level);

    //Traverse to left then right of the tree
    topViewRecursive(root.left, key-1, level+1, mappedLevels);
    topViewRecursive(root.right, key+1, level+1, mappedLevels);
  } */


  // ========================
  // Demo
  // ========================
  public static void main(String[] args) {
    // ====--- TreeView #1 --- ====
    String tree =  """
                1
                 \\
                  2
                   \\
                    5
                   / \\
                  3   6
                   \\
                    4
        """;
    System.out.println("Demo tree:");
    System.out.println(tree);

    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(5);
    root.right.right.left = new TreeNode(3);
    root.right.right.right = new TreeNode(6);
    root.right.right.left.right = new TreeNode(4);

    System.out.print("Top View: ");
    topView(root);
    System.out.println();

    // ====--- TreeView #2 --- ====
    String tree2 =  """
                1
               / \\
              2   3
             / \\
            4   5
        """;
    System.out.println("Demo tree2:");
    System.out.println(tree2);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(3);
    root2.left.left = new TreeNode(4);
    root2.left.right = new TreeNode(5);

    System.out.print("Top View: ");
    topView(root2);
    System.out.println();

    // ====--- TreeView #3 --- ====
    String tree3 =  """
                50
              /    \\
            30      70
           /  \\    /  \\
         20   40  60   80
              /      \\
            35        65
           /            \\
         33              68
        /
      31
        """;
    System.out.println("Demo tree3:");
    System.out.println(tree3);

    TreeNode root3 = new TreeNode(50);

    root3.left = new TreeNode(30);
    root3.right = new TreeNode(70);
    root3.left.left = new TreeNode(20);
    root3.left.right = new TreeNode(40);
    root3.right.left = new TreeNode(60);
    root3.right.right = new TreeNode(80);
    root3.left.right.left = new TreeNode(35);
    root3.left.right.left.left = new TreeNode(33);
    root3.left.right.left.left.left = new TreeNode(31);
    root3.right.left.right = new TreeNode(65);
    root3.right.left.right.right = new TreeNode(68);

    System.out.print("Top View: ");
    topView(root3);
  }

}
/* 
  Some more explanations:

  ====--- TreeView #3 --- ====
                50            0
              /    \
            30      70        -1 | 1
           /  \    /  \
         20   40  60   80     -2 | 0, 0 | +2
              /      \
            35        65      - | -1, +1 | +
           /            \
         33              68   - | -2, +2 | +
        /
      31                      -3 | , | +
  Horizontal Distances (HD)
    HD -3 : 31
    HD -2 : 20
    HD -1 : 30
    HD  0 : 50
    HD +1 : 70
    HD +2 : 80
    HD +3 : 68
  Top View Result:
    31 20 30 50 70 80 68
  
  ====--- TreeView #4 --- ====
          10        0
         /  \
        5    15     -1, +1
         \
          7         0
           \
            8       1
             \
              9     2
  Horizontal Distances (HD)
    HD -1 : 5
    HD  0 : 10
            7
    HD +1 : 15
            8
    HD +2 : 9
  Top View Result:
    5 10 15 9
 */
