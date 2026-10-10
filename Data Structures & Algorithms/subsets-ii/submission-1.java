class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> subsetResult = new HashSet<>();
        findSubsetsByBacktrack(nums,0,new ArrayList<>(), subsetResult);
        return new ArrayList<>(subsetResult);
    }
    private void findSubsetsByBacktrack(int[] nums, int index, List<Integer> list, Set<List<Integer>> subsetResult){
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
