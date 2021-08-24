class MirrorBinaryTree {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node root) {
        if(root==null)
            return;
        Node t=root.left;
        root.left=root.right;
        root.right=t;
        mirror(root.left);
        mirror(root.right);
    }
}
