class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        int[] result = new int[length - k + 1];
        int idx = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        while(right < length){
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]){
                deque.pollLast();
            }
            deque.addLast(right);

            while(deque.peekFirst() < left){
                deque.pollFirst();
            }
            if(right - left + 1 == k){
                result[idx++] = nums[deque.peekFirst()];
                left++;
            }
            right++;
        }
        return result;
    }
}
