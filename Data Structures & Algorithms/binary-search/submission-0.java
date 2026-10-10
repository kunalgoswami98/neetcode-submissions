class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0) return -1;

        int start = 0;
        int end = length-1;

        while(start <= end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}
