class reverseLeveLOrder
{
    public ArrayList<Integer> reverseLevelOrder(Node root) 
    {
        if(root==null) return null;
        Queue<Node> q=new LinkedList<>();
        LinkedList<Integer> list=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node x=q.poll();
            list.addFirst(x.data);
            if(x.right!=null) q.offer(x.right);
            if(x.left!=null) q.offer(x.left);
        }
        ArrayList<Integer> l=new ArrayList<>(list);
        return l;
    }
}      
