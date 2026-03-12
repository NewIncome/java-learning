/**
 * Tree: LevelOrderTraversal
 * 
 * Print values by level
 * example:
 *      1
 *       \
 *         2
 *          \
 *           5
 *          /  \
 *         3    6
 *          \
 *           4
 * 
 * output:  1 2 5 3 6 4
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import utility.TreeNode;


public class TreeLevelOrderTraversal {

  // Solution for Tree:LOT challenge
  static class NodeHD {
    private Node node;
    int hd;
    NodeHD(Node node, int hd) {
      this.node = node;
      this.hd = hd;
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
	public static void levelOrder(Node root) {
    if(root == null) return;
    
    Queue<NodeHD> queue = new LinkedList<>();
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();  //<HD, NodeData>
    
    //initialize the queue
    queue.add(new NodeHD(root, 0));
    
    while(!queue.isEmpty()) {
      // Separate queue/NodeHD content
      NodeHD current = queue.poll();
      Node node = current.node;
      int hd = current.hd;
      
      //add the node data+hd to the map
      if(!map.containsKey(hd)) map.put(hd, new LinkedList<>());
      map.get(hd).add(node.data);
      
      // Check Branches
      if(node.left != null)
        queue.add(new NodeHD(node.left, hd+1));
      if(node.right != null)
        queue.add(new NodeHD(node.right, hd+1));
      
      /* printQueue(queue);
      printMap(map);
      System.out.println(); */
    }
    
      // Print the map values
      map.values()
          .stream()
          .flatMap(List::stream)
          .forEach(i -> System.out.print(i + " "));
  }

  // Helper methods for debugging, printing values
  public static void printQueue(Queue<NodeHD> q) {
    if(q.isEmpty()) return;
    System.out.println("Queue:");
    for(NodeHD pnode : q){
      System.out.println(" level(hd): " + pnode.hd +
        ", node.data: " + pnode.node.data);
    }
  }
  public static void printMap(TreeMap<Integer, List<Integer>> map) {
    if(map.isEmpty()) return;
    System.out.println("TreeMap<Integer, List<Integer>>:");
    for(Integer key : map.keySet()) {
      System.out.println(" <" + key +
        ", " + map.get(key).toString() + ">");
    }
  }

}
