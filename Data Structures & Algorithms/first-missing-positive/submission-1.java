class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        boolean[] arr = new boolean[length];

        for(int num: nums){
            if(num > 0 && num <= length){
                arr[num-1] = true;
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(!arr[i]) {
                return i + 1;
            }
        }
        return length + 1;
    }
}