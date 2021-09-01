class bottomView
{
    //Function to return a list containing the bottom view of the given tree.
    
    static void F(Node root,int hd,int level,TreeMap<Integer,pair> map){
        if(root==null) return;
        if(map.getOrDefault(hd,null)==null || level>=map.get(hd).level){
            map.put(hd,new pair(root.data,level));
        }
        F(root.left,hd-1,level+1,map);
        F(root.right,hd+1,level+1,map);
    }
    
    public ArrayList <Integer> bottomView(Node root)
    {
        TreeMap<Integer,pair> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        F(root,0,0,map);
        for(pair value:map.values())
            list.add(value.data);
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
