public class MyClass {
    public static void main(String args[]) {
        HashMap map = new HashMap();
        map.put(1,2);
        map.put(2,3);
        map.put(2,4);
        map.put(3,56);
        map.put(4,56);
        map.put(5,55);
        map.put(6,56);
        map.put(7,56);
        map.put(8,56);
        map.put(9,56);
        map.put(10,56);
        map.put(11,56);
        map.put(12,56);
        map.put(13,56);
        map.put(14,56);
        map.put(166,56);
        map.put(0,123123);
        map.put(1000000,121212);
        map.put(1000001,1234535);
        for(int i=0;i<1000000;i++){
            node t=map.table[i];
            System.out.println("hash value "+i);
            while(t!=null){
                System.out.println(t.key+" "+t.value);
                t=t.next;
            }
        }
       
    }
}

class HashMap{
    int size;
    node table[]=new node[1000000];
    private int hash(int key){
        key=Math.abs(key); //for negative values
        int index=key%1000000;
        //System.out.println("key->index "+key+" "+index);
        return index; 
    }
    
    void put(int key,int value){
        int index=hash(key);
        if(table[index]==null){
            table[index]=new node(key,value);
            size++;
            return;
        }
        else{
           node t=table[index];
           while(t.next!=null && t.key!=key){
               t=t.next;
           }
           if(t.key==key)  //if key is already present in table update value to new value dont increase the size
               t.value=value;
           else{
               t.next=new node(key,value);
               size++;
           }
        }
    }

int get(int key){
    int index=hash(key);
    if(table[index]==null) return -1;
    node t=table[index];
    while(t!=null && t.key!=key){  //traverse until key is found
        t=t.next;
    }
    if(t==null) return -1;   //if key does not exist
    return t.value;          //return value stored in the pair(key,value)
} 


int remove(int key){
    int index=hash(key);
    if(table[index]==null) {  System.out.println("key not found-> "+key); return -1;}  //key not found
    if(table[index].key==key) { size--; table[index]=table[index].next; return 0;}  //when key is present in 1st node
    node t=table[index],prev=null;
    while(t!=null && t.key!=key){
        t=t.next;
    }
    if(t==null){  System.out.println("key not found-> "+key);return -1;   }         //key not found
    System.out.println("removed "+t.key+" "+t.value);
    prev.next=t.next;
    size--;
    return 0;
}

int size(){
    return size;
}
}

class node{
    int key,value;
    node next;
    node(int key,int value){
        this.key=key;
        this.value=value;
    }
}
