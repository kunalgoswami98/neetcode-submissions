class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] result = new int[length];
        int temp = nums[0];
        result[0] = 1;
        for(int i = 1; i < length; i++){
            result[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for(int i = length-1; i >= 0; i--){
            result[i] = result[i] * temp;
            temp *= nums[i];
        }

        return result;
    }
}  
