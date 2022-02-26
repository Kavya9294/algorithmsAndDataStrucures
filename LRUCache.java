class LRUCache {
    
    class DllNode{
        DllNode next;
        DllNode prev;
        int value;
        int key;
        DllNode(){}
        
        DllNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    
    public void addNode(int key, int value){
        DllNode node = new DllNode(key,value);
        DllNode n = this.head.next;
        this.head.next=node;
        node.next=n;
        n.prev=node;
        node.prev=this.head;
        map.put(key,node);
    }
    
    public void removeNode(DllNode node){
        map.remove(node.key);
        DllNode p = node.prev;
        DllNode n = node.next;
        p.next = n;
        n.prev=p;
    }
    
    
    
    Map<Integer, DllNode> map;
    int capacity=0;
    DllNode head;
    DllNode tail;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<>();
        head = new DllNode();
        tail = new DllNode();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            DllNode temp=map.get(key);
            int value = temp.value;
            removeNode(temp);
            addNode(key,value);
            return value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DllNode  node = map.get(key);
            removeNode(node);
        }
        if(map.size()>=this.capacity){
            DllNode  last = this.tail.prev;
            removeNode(last);
        }
        addNode(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */