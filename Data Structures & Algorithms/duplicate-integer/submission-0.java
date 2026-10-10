class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numbersSoFar = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(numbersSoFar.contains(nums[i])) return true;
            numbersSoFar.add(nums[i]);
        }
        return false;
    }
}
