public class HeightOfBinaryTree {

  public static void main(String[] args) {
  }


  public static int height(Node root) {
    //It's not 0 because it adds 1 also when root == 0, in the method call
    return recursiveHeight(root, -1);
  }

  public static int recursiveHeight(Node root, int floor) {
    if(root == null) return floor;
    
    return Math.max(recursiveHeight(root.left, floor+1), recursiveHeight(root.right, floor+1));
  }

}
