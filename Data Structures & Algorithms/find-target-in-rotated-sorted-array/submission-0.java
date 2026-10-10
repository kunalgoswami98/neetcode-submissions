class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;

        int pivot = findPivot(nums);
        int result = 0;
        if(target >= nums[pivot] && target <= nums[length-1]){
            result = findTarget(nums,pivot,length-1,target);
        }
        else{
            result = findTarget(nums,0,pivot-1,target);
        }
        return result;
    }
    private int findPivot(int[] nums){
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] > nums[nums.length-1]) start = mid + 1;
            else end = mid -1;
        }
        return start;
    }
    private int findTarget(int[] nums, int start, int end, int target){
        if(start > end) return -1;

        int mid = start + (end - start)/2;
        if(target == nums[mid]) return mid;
        else if(target > nums[mid]) return findTarget(nums,mid+1,end, target);
        else return findTarget(nums,start,mid-1,target);
    }
}
