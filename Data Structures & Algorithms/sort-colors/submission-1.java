class Solution {
    public void sortColors(int[] nums) {
        int zeroPointer = 0;
        int twoPointer = nums.length-1;
        int i = 0;
        while(i <= twoPointer){
            if(nums[i] == 0){
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[i];
                nums[i] = temp;
                zeroPointer++;
                i++;
            }
            else if(nums[i] == 2){
                int temp = nums[twoPointer];
                nums[twoPointer] = nums[i];
                nums[i] = temp;
                twoPointer--;
            }
            else i++;
        }
    }
}