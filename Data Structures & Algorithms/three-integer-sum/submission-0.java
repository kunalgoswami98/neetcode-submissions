class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> resultThreeSum = new ArrayList<>();
        Arrays.sort(nums);
        for(int first = 0; first < length - 2; first++){
            if(nums[first] > 0) break;
            if(first > 0 && nums[first] == nums[first-1]) continue;
            int target = -nums[first];
            int start = first+1;
            int end = length-1;

            while(start < end){
                int sum = nums[start] + nums[end];
                if(sum < target){
                    start++;
                }
                else if(sum > target) end--;
                else {
                    resultThreeSum.add(Arrays.asList(nums[first],nums[start],nums[end]));
                    start++;
                    end--;
                    while(start < end && nums[start] == nums[start-1]) start++;
                }
            }
        }
        return resultThreeSum;
    }
}
