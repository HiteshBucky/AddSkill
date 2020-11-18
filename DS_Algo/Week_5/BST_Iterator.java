class BSTIterator {
    
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        traverseTree(root);
    }
    
    private void traverseTree(TreeNode node) {
        while (null != node) {
            stack.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        if (hasNext()) {
            TreeNode node = stack.pop();
            traverseTree(node.right);
            return node.val;
        }
        return -1;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}