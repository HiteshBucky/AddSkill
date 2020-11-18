class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //List to store all nodes val
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null) return res;
        
        //Starting the BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(queue.size() > 0) {
            List<Integer> list = new ArrayList();
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(res.size(), list);
        }
        return res;
    }
}