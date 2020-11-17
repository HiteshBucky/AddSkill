class Pair {
	int first, second;

	Pair(int a, int b){
		first = a;
		second = b;
	}
}

public int diameterOfBinaryTree(TreeNode root) {
    return dfs(root).first;
}

public Pair dfs(TreeNode root){
	if(root == null) return new Pair(0,0);

	Pair left = dfs(root.left);
	Pair right = dfs(root.right);

	int diameter = Math.max( (Math.max(left.first, right.first)), (left.second + right.second) );

	return new Pair(diameter, Math.max(left.second, right.second) +1);
}


