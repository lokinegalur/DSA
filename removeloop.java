class Solution
{
    //Function to remove a loop in the linked list.
    //using hashset
    public static void removeLoop(Node head){
        if(head==null || head.next==null) return;
        HashSet<Node> set=new HashSet<>();
        Node p=head;
        while(p!=null){
            if(set.contains(p)) break;
            set.add(p);
            p=p.next;
        }
        if(p==null) return;
        Node t=p.next;
        while(t.next!=p)
            t=t.next;
        t.next=null;
        return;
    }
    
    //slow and fast pointer
    public static void removeLoop(Node head){
        if(head==null || head.next==null) return;
        Node s=head,f=head.next.next;
        while(f!=null && f.next!=null){
            if(s==f) break;
            s=s.next;
            f=f.next.next;
        }
        if(f==s){
            s=head;
            while(s.next!=f.next){
                s=s.next;
                f=f.next;
                }
            f.next=null;
        }
    }
}
