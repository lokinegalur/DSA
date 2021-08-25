class preOrderIter {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        if(root==null) return l;
        Stack<TreeNode> s=new Stack<>();
        TreeNode curr=root;
        while(curr!=null || !s.isEmpty()){
            if(curr!=null){
                l.add(curr.val);
                s.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode x=s.pop();
                curr=x.right;
            }
        }
        return l;
    }
  
  public static void inorderRec(Node root){
    if(root!=null){
      System.out.println(root.data);
      inorderRec(root.left);
      inorderRec(root.right);
    }
  }
}
