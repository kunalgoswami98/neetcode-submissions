class KthLargest {
    Queue<Integer> minHeap;
    int capacity;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>((a,b) -> a - b);
        this.capacity = k;
        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size() > this.capacity){
                minHeap.remove();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > this.capacity){
            minHeap.remove();
        }
        return minHeap.peek();
    }
}
