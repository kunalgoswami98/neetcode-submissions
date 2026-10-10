class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        if(length == 0) return -1;
        int majority = nums[0];
        int majCount = 1;
        for(int i = 1; i < length; i++){
            if(nums[i] != majority){
                majCount--;
            }
            else majCount++;
            if(majCount < 0){
                majority = nums[i];
                majCount = 1;
            }
        }
        return majority;
    }
}