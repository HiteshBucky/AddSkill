/*
	Leetcode Solution

	class Solution {
	    public boolean isValidBST(TreeNode root) {
	        return isValidBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
	    }
	    
	    public boolean isValidBST(TreeNode root,long min,long max){
	        
	        if(root == null) return true;
	        
	        if(root.val >= min || root.val <= max) return false;
	        
	        return isValidBST(root.left,root.val,max) && isValidBST(root.right,min,root.val);
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

	boolean isBST(){
		return isBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}

	boolean isBST(Node root, long min, long max){
		// If tree is empty
		if(root == null) return true;
        
        if(root.value >= min || root.value <= max) return false;
        
        return isBST(root.left, root.value, max) && isBST(root.right, min, root.value);
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