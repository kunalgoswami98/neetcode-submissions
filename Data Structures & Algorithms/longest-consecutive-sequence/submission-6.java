class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int longest = 1;
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i]-1)) continue;
            int count = 1;
            while(set.contains(nums[i] + count)){
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
