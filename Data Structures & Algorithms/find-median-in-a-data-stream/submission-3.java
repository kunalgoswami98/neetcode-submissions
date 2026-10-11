class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if(maxHeap.size()-minHeap.size() > 1 ||
        !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            minHeap.add(maxHeap.remove());
        }

        if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (double)(minHeap.peek()+maxHeap.peek())/(double)2;
        }
        if(minHeap.size() > maxHeap.size()){
            return (double)minHeap.peek();
        }
        return (double)maxHeap.peek();
    }
}
// 5,3,7