class Solution {
    // using slow and fast pointer
    public static boolean detectLoopSlowFastPointer(Node head){
      if(head==null || head.next==null) return false;
      Node slow=head,fast=head.next;
      while(fast!=null && fast.next!=null){
          if(fast==slow) return true;
          slow=slow.next;
          fast=fast.next.next;
      }
      return false;
    }
 
  // using hashSet
  public static boolean detectLoopSet(Node head){
      if(head==null || head.next==null) return false;
      Node p=head;
      HashSet<Node> set=new HashSet<>();
      while(p!=null){
          if(set.contains(p))
            return true;
          set.add(p);
          p=p.next;
      }
      return false;
    }
}
