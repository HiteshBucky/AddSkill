/*
	Leetcode Solution

	class Solution {
	    public boolean isSymmetric(TreeNode root) {
	        return isMirror(root, root);
	    }
	    
	    public boolean isMirror(TreeNode node1, TreeNode node2){
	        if (node1 == null && node2 == null) return true; 
	        
	        if (node1 != null && node2 != null && node1.val == node2.val) 
	            return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
	         
	        return false; 
	    }
	}

*/
import java.util.*;

class Node {
	int value; 
    Node left, right; 
      
    Node(int value){ 
        this.value = value; 
        left = null; 
        right = null; 
    }
}

class BinaryTree{

	Node root;

	public boolean isSymmetric(Node root) {
        return isMirror(root, root);
    }
    
    public boolean isMirror(Node node1, Node node2){
        if (node1 == null && node2 == null) return true; 
        
        if (node1 != null && node2 != null && node1.value == node2.value) 
            return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
         
        return false; 
    }

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		System.out.println(tree.isBST() ? "IS BST" : "Not a BST");
	}
}