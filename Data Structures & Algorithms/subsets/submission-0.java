class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();

        List<List<Integer>> subsetResult = new ArrayList<>();
        findSubsetsByBacktrack(nums,0,new ArrayList<>(), subsetResult);
        return subsetResult;
    }
    private void findSubsetsByBacktrack(int[] nums, int index, List<Integer> list, List<List<Integer>> subsetResult){
        if(index == nums.length){
            subsetResult.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        findSubsetsByBacktrack(nums,index+1,list,subsetResult);
        list.remove(list.size()-1);
        findSubsetsByBacktrack(nums,index+1,list,subsetResult);
    }
}
