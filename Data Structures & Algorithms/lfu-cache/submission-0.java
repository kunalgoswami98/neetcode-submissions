class LFUCache {
    class Node{
        int key;
        int value;
        int frequency;

        Node(int key, int value, int frequency){
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }
    Map<Integer, Node> keyMapping;
    Map<Integer, LinkedHashSet<Integer>> frequencyMap;
    int maxCapacity;
    int minFrequency;
    public LFUCache(int capacity) {
        keyMapping = new HashMap<>();
        frequencyMap = new HashMap<>();
        this.maxCapacity = capacity;
        this.minFrequency = Integer.MAX_VALUE;
    }
    
    public int get(int key) {
        if(!keyMapping.containsKey(key)) return -1;
        Node nodeValue = keyMapping.get(key);
        frequencyMap.get(nodeValue.frequency).remove(key);
        //update minFrequency if changed
        if(minFrequency == nodeValue.frequency && frequencyMap.get(nodeValue.frequency).size() == 0){
            minFrequency += 1;
        }
        if(frequencyMap.get(nodeValue.frequency).size() == 0){
            frequencyMap.remove(nodeValue.frequency);
        }
        //create mapping with increased frequency
        nodeValue.frequency += 1;
        frequencyMap.computeIfAbsent(nodeValue.frequency, k -> new LinkedHashSet<>()).add(key);
        keyMapping.put(key, nodeValue);
        return nodeValue.value;
    }
    
    public void put(int key, int value) {
        //if key already present
        if(keyMapping.containsKey(key)) {
            Node nodeValue = keyMapping.get(key);
            frequencyMap.get(nodeValue.frequency).remove(key);
            //update minFrequency if changed
            if(minFrequency == nodeValue.frequency && frequencyMap.get(nodeValue.frequency).size() == 0){
                minFrequency += 1;
            }
            if(frequencyMap.get(nodeValue.frequency).size() == 0){
                frequencyMap.remove(nodeValue.frequency);
            }
            //create mapping with increased frequency
            nodeValue.frequency += 1;
            nodeValue.value = value;
            frequencyMap.computeIfAbsent(nodeValue.frequency, k -> new LinkedHashSet<>()).add(key);
            keyMapping.put(key, nodeValue);
        }
        else {
            //if maxCapacity reached
            if(keyMapping.size() == maxCapacity){
                //delete least frequenctly used key
                LinkedHashSet<Integer> set = frequencyMap.get(minFrequency);
                int removalKey = set.iterator().next();
                set.remove(removalKey);
                keyMapping.remove(removalKey);
            }
            Node newNode = new Node(key, value, 1);
            minFrequency = Math.min(minFrequency, newNode.frequency);
            frequencyMap.computeIfAbsent(newNode.frequency, k -> new LinkedHashSet<>()).add(key);
            keyMapping.put(key, newNode);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */