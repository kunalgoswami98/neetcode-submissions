class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int numsLength = nums.length;
        if(numsLength == 0) return 0;
        int longestSequenceCount = Integer.MIN_VALUE;
        int currentLongestSequence = 0;

        for(int num : nums){
            set.add(num);
        }

        int index = 0;
        for(int num : set){

            if(!set.contains(num-1)){
                currentLongestSequence = 1;
                int nextNumber = num+1;
                while(set.contains(nextNumber)){
                    currentLongestSequence++;
                    nextNumber++;
                    index++;
                }
                longestSequenceCount = Math.max(longestSequenceCount, currentLongestSequence);
            }
        }
        return longestSequenceCount;
    }
}
