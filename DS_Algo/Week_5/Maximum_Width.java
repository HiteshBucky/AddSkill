class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(curr);
        Map<TreeNode, Integer> posDic = new HashMap<>();
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int left = -1;
            for(int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if(i == 0) left = posDic.getOrDefault(n, 1); 
                
                if(n.left != null) {
                    queue.offer(n.left);
                    posDic.put(n.left, posDic.getOrDefault(n, 1) * 2);
                }
                if(n.right != null) {
                    queue.offer(n.right);
                    posDic.put(n.right, posDic.getOrDefault(n, 1) * 2 + 1);
                }
                max = Math.max(max, posDic.getOrDefault(n, 1) - left + 1);
            }
        }
        return max;
    }
}