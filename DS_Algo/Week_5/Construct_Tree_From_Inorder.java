class Solution {
    int preIndex = 0; 
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int preorder[], int inorder[], int inStrt, int inEnd) 
    { 
        if (inStrt > inEnd) return null; 
  
        TreeNode tNode=new TreeNode(preorder[preIndex++]); 
  
        if (inStrt == inEnd) return tNode; 
  
        int inIndex = search(inorder, inStrt, inEnd, tNode.val); 
  
        tNode.left = buildTree(preorder, inorder, inStrt, inIndex - 1); 
        tNode.right = buildTree(preorder, inorder, inIndex + 1, inEnd); 
  
        return tNode; 
    }
    
    public int search(int arr[], int strt, int end, int value) {  
        for(int i=strt;i<=end;i++) 
            if(arr[i]==value) return i;
        
        return -1;
    }  
    
}