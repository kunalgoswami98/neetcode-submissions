class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums);        
        return nums;
    }

    private void mergeSort(int[] nums) {
        divide(nums, 0, nums.length - 1);
    }

    private void divide(int[] nums, int l, int r) {
        if(l == r) return;
        int m = (l + r) / 2;
        divide(nums, l, m);
        divide(nums, m + 1, r);
        conquer(nums, l, m, r);
    }

    private void conquer(int[] nums, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int[] sorted = new int[r - l + 1];
        int x = 0;
        while(i <= m && j <= r) {
            if(nums[i] < nums[j]) {
                sorted[x++] = nums[i++];
            } else {
                sorted[x++] = nums[j++];
            }
        }
        while(i <= m) {
            sorted[x++] = nums[i++];
        }
        while(j <= r) {
            sorted[x++] = nums[j++];
        }
        for(int k = l; k <= r; k++) {
            nums[k] = sorted[k - l];
        }
    }
}