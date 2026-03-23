/**
 * You are given a pointer to the root of a binary search tree and values
 * to be inserted into the tree. Insert the values into their appropriate
 * position in the binary search tree and return the root of the updated
 * binary tree. You just have to complete the function.
 * • Input
 *  + Node * root ,int data
 *  ie.: 4 2 3 1 7 6
 * • Output
 *  + Return the root of the binary search tree after inserting the value into the tree.
 *  ie.: 4 2 1 3 7 6 
 * • Constraints
 *  + No. of nodes in the tree <= 500
 * • Sample Input
 *  +   4
       / \
      2   7
     / \
    1   3
 * • Sample Output
    +    4
       /   \
      2     7
     / \   /
    1   3 6
 */
/*
  Pseudocode
  ○ create var for currentNode, for traversing
  ○ Loop through array while(currentNode != null)
    //Check if current position is the correct place
    // IS data toBeSet left?
    + if currentNode.left.data == null && data < currentNode.data
      + set data to currentNode.left ; and break(return root);
    // IS data toBeSet left?
    + else if currentNode.right.data == null && data < currentNode.data
      + set data to currentNode.right ; and break(return root);
    //Move left or right
    + else if currentNode.left.data < data : currentNode = currentNode.left
    + else if currentNode.right.data > data : currentNode = currentNode.left
 */
import org.w3c.dom.Node;


public class BinarySearchTreeInsertion {

  /* To traverse a BST we use 
   */

  // Iterative
  public static Node insertI(Node root, int data) {  //1st time didn't check case root == null
    if(root == null) return new Node(data);
    Node cNode = root;  //currentNode

    while(cNode !=  null) {
      //Check Left / Lower-data
      if(data < cNode.data) {
        //check if to-set or to-move
        if(cNode.left == null) {  //set
          cNode.left = new Node(data);
          break;
        } else {  //move
          cNode = cNode.left;
        }
      }
      //Check Right / Higher-data
      else if(data > cNode.data) {    //this can be an else, else for duplicate values not needed to check
        //check if to-set or to-move
        if(cNode.right == null) {
          cNode.right = new Node(data);
          break;
        } else {  //move
          cNode = cNode.right;
        }
      }
      //in case of duplicate values
      else
        break;
    }

    return root;
  }

  //recursive
  public static Node insertR(Node root, int data) {
    if(root == null) {
      root = new Node(data);
      return root;
    }
    else if(data < root.data) {
      root.left = insertR(root.left, data);
    } else {
      root.right = insertR(root.right, data);
    }

    return root;
  }


  // ========================
  // Demo
  // ========================
  public static void main(String[] args) {
  }

}

/* 1st Try, Why doesn't it work?? ???
  public static Node insertI(Node root, int data) {  /1st time didn't check case root == null
    if(root == null) return new Node(data);
    Node cNode = root;

    while(cNode !=  null) {
      if(cNode.left == null && data < cNode.data) {
        cNode.left = new Node(data);
        return root;
      }
      else if(cNode.right == null && data < cNode.data) {
        cNode.right = new Node(data);
        return root;
      }
      //If not time to set data, traverse
      else if(data < cNode.data)
        cNode = cNode.left;
      else
        cNode = cNode.right;
    }

    return root;
  }
 */
