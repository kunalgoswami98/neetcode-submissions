class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        if(nums.length == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        combinationSumBack(nums,0, target, result, list);
        return result;
    }
    private void combinationSumBack(int[] nums, int index, int target, List<List<Integer>> result , List<Integer> list){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target < 0|| index == nums.length){
            return;
        }

        list.add(nums[index]);
        combinationSumBack(nums,index+1,target-nums[index],result,list);
        list.remove(list.size()-1);
        while(index + 1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }
        combinationSumBack(nums,index+1,target,result,list);
    }
}
