class Solution {
    public int findMin(int[] nums) {

        int length = nums.length;
        int start = 0;
        int end = length-1;
        if(length == 1) return nums[0];
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[length-1]) end = mid - 1;
            else start = mid + 1;
        }
        return start == length ? nums[length-1] : nums[start];
    }
}
