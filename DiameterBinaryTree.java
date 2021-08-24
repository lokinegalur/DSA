class pair{
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

public class DiameterBinaryTree {
    
    public static pair D(TreeNode root){
        if(root==null) return new pair(0,0);
        pair left=D(root.left);
        pair right=D(root.right);
        int internal_max=Math.max(left.second,right.second);
        if(left.first+right.first+1>internal_max)
            internal_max=left.first+right.first+1;
        return new pair(Math.max(left.first,right.first)+1,internal_max);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        pair result=D(root);
        return Math.max(result.first,result.second)-1;       
    }
}
