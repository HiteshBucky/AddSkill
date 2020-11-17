class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = inorderTraversal(root, new ArrayList<Integer>());
        return list.get(k-1);
    }
    
    public ArrayList<Integer> inorderTraversal(TreeNode root, ArrayList<Integer> list) {
    
        if (root == null) return list;
        
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
        
        return list;
    }
}