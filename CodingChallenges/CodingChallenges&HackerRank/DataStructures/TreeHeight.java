/**
 * Return the Height(depth) of the tree
 */
public class TreeHeight {

    // Solution for Tree:Height challenge
  public static int height(TreeNode root) {
    // Write your code here.
    //It's not 0 because it adds 1 also when root == 0, in the method call
    return recursiveHeight(root, -1);
  }
  public static int recursiveHeight(TreeNode root, int floor) {
    if(root == null) return floor;
    
    return Math.max(recursiveHeight(root.left, floor+1), recursiveHeight(root.right, floor+1));
  }

}