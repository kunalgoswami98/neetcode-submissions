class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        if(length == 0) return -1;
        int majorityEle = 0;
        int count = 0;
        for(int i = 0; i < length; i++){
            if(count == 0){
                majorityEle = nums[i];
            }
            if(nums[i] != majorityEle){
                count--;
            }
            else count++;
        }
        return majorityEle;
    }
}