/**
 * TREES
 *        A
 *     /    \
 *    B      C
 *  /   \  /   \
 * D    E  F    G
 * 
 * Depth First Search approaches  (in/post/pre-Order)
 *   behave like a stack(LIFO)
 * BFS behaves like a queue(FIFO)
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
    System.out.println(root.data);
    inOrderTraversal(root.left);
    inOrderTraversal(root.right);
  }

}


class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;

  public TreeNode(int data) { this.data = data; }
}

/*
  Example Tree #2
     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4  
  inOrder:   1 2 3 4 5 6
  preOrder:  1 2 5 3 4 6
  postOrder: 4 3 6 5 2 1
 */