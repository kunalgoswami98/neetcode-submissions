class Solution {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;

        Map<Integer, Integer> sumToFrequencyMap = new HashMap<>();
        sumToFrequencyMap.put(0, 1);
        int sum = 0;
        int result = 0;

        for(int i = 0; i < length; i++){

            sum += nums[i];
            if(sumToFrequencyMap.containsKey(sum-k)){
                result += sumToFrequencyMap.get(sum-k);
            }

            sumToFrequencyMap.put(sum, sumToFrequencyMap.getOrDefault(sum,0)+1);
        }
        return result;
    }
}