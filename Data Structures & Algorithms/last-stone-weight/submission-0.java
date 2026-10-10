class Solution {
    public int lastStoneWeight(int[] stones) {
        int length = stones.length;
        if(length == 0) return 0;

        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b -a);

        for(int stone : stones){
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1){
            int first = maxHeap.remove();
            int second = maxHeap.remove();
            int leftOut = first - second;
            maxHeap.add(leftOut);
        }
        return maxHeap.peek();
    }
}
