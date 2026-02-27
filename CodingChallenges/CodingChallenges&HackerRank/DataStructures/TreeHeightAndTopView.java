import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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
 */

public class TreeHeightAndTopView {

  public static void main(String[] args) {
  }


  //Hindi version
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
  }

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


  public static int height(Node root) {
    // Write your code here.
    return recursiveHeight(root, -1);
    //It's not 0 because it adds 1 also when root == 0, in the method call
  }
  public static int recursiveHeight(Node root, int floor) {
    if(root == null) return floor;
    
    return Math.max(recursiveHeight(root.left, floor+1), recursiveHeight(root.right, floor+1));
  }

}
