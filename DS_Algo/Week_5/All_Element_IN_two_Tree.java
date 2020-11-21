/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //Storing the all data
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        getAllElementsFromRoot(root1); //from tree 1
        
        getAllElementsFromRoot(root2); // from tree 2
        
        Collections.sort(result); // sort the list
        
        return result ; 
    }
    
    public void getAllElementsFromRoot(TreeNode root) {
        if(root == null) return;
        getAllElementsFromRoot(root.left);
        result.add(root.val);
        getAllElementsFromRoot(root.right);
    }
}