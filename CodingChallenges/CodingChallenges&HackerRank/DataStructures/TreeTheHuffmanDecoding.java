/**
 * Huffman coding assigns variable length codewords to fixed length input characters
 * based on their frequencies. More frequent characters are assigned shorter codewords
 * and less frequent characters are assigned longer codewords. All edges along the path
 * to a character contain a code digit. If they are on the left side of the tree, they
 * will be a 0 (zero). If on the right, they'll be a 1 (one). Only the leaves will
 * contain a letter and its frequency count. All other nodes will contain a null instead
 * of a character, and the count of the frequency of all of it and its descendant
 * characters.
 * For instance, consider the string ABRACADABRA. There are a total of  characters in
 * the string. This number should match the count in the ultimately determined root of
 * the tree. Our frequencies are  and . The two smallest frequencies are for  and ,
 * both equal to , so we'll create a tree with them. The root node will contain the sum
 * of the counts of its descendants, in this case . The left node will be the first
 * character encountered, , and the right will contain . Next we have  items with a
 * character count of : the tree we just created, the character  and the character .
 * The tree came first, so it will go on the left of our new root node.  will go on the
 * right. Repeat until the tree is complete, then fill in the 's and 's for the edges.
 * • Example
 *  + s="1001011"  //ABACA
 *    S="1001011"
 *   Processing the string from left to right.
 *   S[0]='1' : we move to the right child of the root. We encounter a leaf node with value 'A'. We add 'A' to the decoded string.
 *   We move back to the root.
 *
 *   S[1]='0' : we move to the left child. 
 *   S[2]='0' : we move to the left child. We encounter a leaf node with value 'B'. We add 'B' to the decoded string.
 *   We move back to the root.
 *
 *   S[3] = '1' : we move to the right child of the root. We encounter a leaf node with value 'A'. We add 'A' to the decoded string.
 *   We move back to the root.
 *
 *   S[4]='0' : we move to the left child. 
 *   S[5]='1' : we move to the right child. We encounter a leaf node with value C'. We add 'C' to the decoded string.
 *   We move back to the root.
 *
 *   S[6] = '1' : we move to the right child of the root. We encounter a leaf node with value 'A'. We add 'A' to the decoded string.
 *   We move back to the root.
 *
 *   Decoded String = "ABACA"
 * 
 * • TestCase
 *  + s="Rumpelstiltskin"
 *  + s="howmuchwoodwouldawoodchuckchuckifawoodchuckcouldchuckwood?"
 */

public class TreeTheHuffmanDecoding {

    void decode(String s, Node root) {  //s="1001011"
        if(root == null) return;
        if(root.left == null && root.right == null) System.out.println(root.data);
        
        int dir;
        Node current = root;
        //Queue<Node> queue = new LinkedList<>();

        for(String i : s.split("")) {
            dir = Integer.parseInt(i);
            if(dir == 0) {
                //System.out.println("went left, " + dir);
                current = current.left;
            }
            else {
                //System.out.println("went right, " + dir);
                current = current.right;
            }
            //System.out.println("data: " + current.data + ", freq: " + root.frequency + ", [A-Z]? " + (String.valueOf(current.data).matches("[A-Z]")));
            if(!Character.isIdentifierIgnorable(current.data)) {
                System.out.print(current.data);
                current = root;
            }
        }
        
    }

}
