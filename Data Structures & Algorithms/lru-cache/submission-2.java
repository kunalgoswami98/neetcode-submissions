class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }
    Node head;
    Node tail;
    Map<Integer, Node> nodeMapper;
    int maxCapacity;
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        nodeMapper = new HashMap<>();
        this.maxCapacity = capacity;
    }
    
    public int get(int key) {
        if(!nodeMapper.containsKey(key)) return -1;
        Node currentNode = nodeMapper.get(key);
        touchNode(currentNode);
        moveToHead(currentNode);

        return currentNode.value;
    }
    
    public void put(int key, int value) {
        if(nodeMapper.containsKey(key)){
            Node currentNode = nodeMapper.get(key);
            currentNode.value = value;
            touchNode(currentNode);
            moveToHead(currentNode);
        }
        else{
            if(nodeMapper.size() == this.maxCapacity){
                Node removalNode = tail.prev;
                nodeMapper.remove(removalNode.key);
                touchNode(removalNode);
            }
            Node currentNode = new Node(key, value);
            moveToHead(currentNode);
            nodeMapper.put(key, currentNode);
        }
    }

    private void touchNode(Node currentNode){
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
    }

    private void moveToHead(Node currentNode) {
        currentNode.next = head.next;
        currentNode.prev = head;
        head.next.prev = currentNode;
        head.next = currentNode;
    }
}
