/**
 * TREES
 *        A
 *     /    \
 *    B      C
 *  /   \  /   \
 * D    E  F    G
 */

import javax.swing.tree.TreeNode;


public class Trees {

  // In-Order, will traverse the tree in this order:  D B E A F C G ;  left -> root -> right
  void traverseInOrder(TreeNode root) {
    inOrderTraversal(root.left);
    System.out.println(root.data);
    inOrderTraversal(root.right);
  }

  // Post-Order, will traverse the tree in this order:  D E B F G C A ;  left -> right -> root
  void traversePostOrder() {
    inOrderTraversal(root.left);
    inOrderTraversal(root.right);
    System.out.println(root.data);
  }

  // Pre-Order ,will traverse the tree in this order:  A B D E C F G ;  root -> left -> right
  void traversePreOrder () {
    inOrderTraversal(root.left);
    System.out.println(root.data);
    inOrderTraversal(root.right);
  }

}


class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;

  public TreeNode(int data) { this.data = data; }
}
