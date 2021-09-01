class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    
    static void F(Node root,int hd,int level,TreeMap<Integer,pair> map){
        if(root==null) return;
        if(map.getOrDefault(hd,null)==null || level<map.get(hd).level){
            map.put(hd,new pair(root.data,level));
        }
        F(root.left,hd-1,level+1,map);
        F(root.right,hd+1,level+1,map);
    }
    static ArrayList<Integer> topView(Node root)
    {
       TreeMap<Integer,pair> map = new TreeMap<>();
       ArrayList<Integer> list = new ArrayList<>();
       F(root,0,0,map);
       for(Integer key:map.keySet())
        list.add(map.get(key).data);
       return list;
    }
}
class pair{
    int data,level;
    pair(int data,int level){
        this.data=data;
        this.level=level;
    }
}
