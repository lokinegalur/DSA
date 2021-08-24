class binaryTreeHeight {
    //Function to find the height of a binary tree.
    int height(Node root) 
    {
       if(root==null) return 0;
       return Math.max(height(root.left),height(root.right))+1;
    }
}
