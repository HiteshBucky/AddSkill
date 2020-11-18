class Solution {
    
    public int sumNumbers(TreeNode root) {
        
        return addRootToLeaf(root,0);
    }
    
    public int addRootToLeaf(TreeNode root, int x)
    {
        if(root==null) return x;
        
        x *= 10;
        x += root.val;
        
        if(root.left == null && root.right == null) return x;
        
        if(root.left == null && root.right != null)
            return addRootToLeaf(root.right,x);
        
        if(root.right == null && root.left != null)
            return addRootToLeaf(root.left,x);
        
        return addRootToLeaf(root.left, x) + addRootToLeaf(root.right, x);
            
    }
}