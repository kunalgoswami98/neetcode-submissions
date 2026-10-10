class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int num: nums){
            pQueue.add(num);
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = pQueue.poll();
        }
        return nums;
    }
}