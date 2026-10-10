class MedianFinder {
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;
    public MedianFinder() {
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftHeap.isEmpty()){
            leftHeap.add(num);
        }
        else if(num > leftHeap.peek()) {
            rightHeap.add(num);
        }
        else {
            leftHeap.add(num);
            int peekElement = leftHeap.remove();
            rightHeap.add(peekElement);
        }
        if(rightHeap.size() > leftHeap.size()) {
            int peekElement = rightHeap.remove();
            leftHeap.add(peekElement);
        }
    }
    
    public double findMedian() {
        if((leftHeap.size() + rightHeap.size()) % 2 == 0) {
            return (double)(leftHeap.peek() + rightHeap.peek()) / 2.0;
        }
        else {
            return (double) leftHeap.peek();
        }
    }
}
