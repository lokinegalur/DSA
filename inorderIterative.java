class inorderIterative
{
	// Iterative function to perform inorder traversal on the tree
	public static void inorderIterative(Node root)
	{
		if(root==null) return;
		Stack<Node> s=new Stack<>();
		Node curr=root;
		while(curr!=null || !s.isEmpty()){
			if(curr!=null){
				s.push(curr);
				curr=curr.left;
			}
			else{
				Node visit=s.pop();
				System.out.print(visit.data+" ");
				curr=visit.right;
			}
		}
	}
  
  public  static void inorderRec(Node root){
    if(root!=null){
      inorderRec(root.left);
      System.out.println(root.data);
      inorderRec(root.right);
    }
  }
}
