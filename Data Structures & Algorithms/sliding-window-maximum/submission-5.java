class Solution {
    class Pair{
        int value;
        int index;
        
        Pair(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> {
            if(b.value == a.value) return a.index - b.index;
            return b.value - a.value;
        });
        int start = 0;
        int end = 0;

        while(end < nums.length && end < k){
            maxHeap.offer(new Pair(nums[end],end));
            end++;
        }

        int[] result = new int[nums.length-k+1];
        int idx = 0;
        result[idx++] = maxHeap.peek().value;
        start++;
        while(end < nums.length){
            while(!maxHeap.isEmpty() && maxHeap.peek().index < start){
                maxHeap.remove();
            }
            maxHeap.offer(new Pair(nums[end], end));
            result[idx++] = maxHeap.peek().value;
            end++;
            start++;
        }
        return result;
    }
}
