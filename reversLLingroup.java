class Solution
{
    public static Node reverse(Node node, int k)          //using stack
    {
        Stack<Integer> s=new Stack<>();
        Node curr=node,head=null,t=null;
        while(curr!=null){
            int i=1;
            while(i<=k && curr!=null){
                s.push(curr.data);
                curr=curr.next;
                i++;
            }
            while(!s.isEmpty()){
                if(head==null){
                    head=new Node(s.pop());
                    t=head;
                    //System.out.println(head.data);
                }
                else{
                    t.next=new Node(s.pop());
                    t=t.next;
                }
            }
        }
        return head;
}
  public static Node reverse(Node head, int k)                       //using iteration for k sublist and recursion for the rest
    {
       Node curr=head,prev=null,next=null;
       int i=0;
       while(i++<k && curr!=null){
           next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
       }
       if(next!=null)
          head.next=reverse(next,k);
       return prev;
    }
}
