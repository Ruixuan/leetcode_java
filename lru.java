public class LRUCache {

    private class Node{
        Node pre, next;
        int val, key;

        public Node(int val, int key){
            this.val = val;
            this.key = key;
            pre = null;
            next = null;
        }
    }

    private Node head, tail;
    private HashMap<Integer, Node> node_map;
    private int size, capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        node_map = new HashMap<Integer, Node>();
        head = null;
        tail = null;
    }

    private void add(Node curr){
        if (head == null){
            head = curr;
            tail = curr;
            node_map.put(curr.key, curr);
        }else{
            curr.next = head;
            head.pre = curr;
            head = curr;
        }
        size ++;

        if (size > capacity){
            node_map.remove(tail.key);
            tail = tail.pre;
            tail.next = null;
            size --;
        }
    }

    private void update(Node curr){
        if (curr.pre == null)
            return;
        curr.pre.next = curr.next;
        if (curr.next != null)
            curr.next.pre = curr.pre;
        head.pre = curr;
        curr.next = head;
        curr.pre = null;
        head = curr;
    }

    public int get(int key) {
       Node curr;
       curr = node_map.get(key);
       update(curr);
       return curr.val;
    }
    
    public void set(int key, int value){
       Node curr;
       if(!node_map.containskey(key)){
           add(new node(value, key));
       }
       curr = node_map.get(key);
       curr.val = value;
       update(curr);
    }
}
