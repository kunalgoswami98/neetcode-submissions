class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        
        for(int i = 0; i < length; i++){
            while(nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]){
                int index = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }

        for(int i = 0; i < length; i++){
            if(nums[i] != i + 1) return i+1;
        }
        return length + 1;
    }
}