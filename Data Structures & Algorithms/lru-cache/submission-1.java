
class LRUCache {
    class Node {
        int value;
        int key;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    Map<Integer,Node> map;
    int currentCapacity;
    int maxCapacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        currentCapacity = 0;
        this.maxCapacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            markNode(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            markNode(node);
            return;
        }
        else if(currentCapacity >= maxCapacity){
            Node node = tail.prev;
            deleteNode(node);
            map.remove(node.key);
            currentCapacity -= 1;
        }
        Node newNode = new Node(key,value);
        map.put(key,newNode);
        markNode(newNode);
        currentCapacity += 1;
    }

    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void markNode(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        head.prev = null;
    }
}
