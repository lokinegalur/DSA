class Solution
{
 
    Node reverseList(Node head)            // iterative
    {
        Node prev=null,curr=head,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
                                          //  tail recursion   
    Node rev(Node head,Node prev){
        if(head==null) return prev;
        Node next=head.next;
        head.next=prev;
        prev=head;
        head=next;
        return rev(head,prev);
    }
    
    Node reverseList(Node head) 
    {
       head=rev(head,null);
       return head;
    }
                                        // recursion normal
    Node reverseList(Node head){
    if(head==null || head.next==null)
      return head;
    Node rest=reverseList(head.next);
    head.next.next=head;
    head.next=null;
    return rest;
    }
}
