class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), permutations, 0);
        return permutations;
    }

    private void backtrack(int[] nums, List<Integer> currentPermutation, List<List<Integer>> permutations, int index) {
        if(currentPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPermutation));
            return;
        }

        for(int i = 0; i <= currentPermutation.size(); i++){
            currentPermutation.add(i,nums[index]);
            backtrack(nums,currentPermutation,permutations,index+1);
            currentPermutation.remove(i);
        }
    }
}
