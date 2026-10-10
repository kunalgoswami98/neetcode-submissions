class Solution {
    public int trap(int[] height) {
        int length = height.length;

        if(length == 1 || length == 2) return 0;

        int[] largestOnRight = getLargestElementOnRight(height);
        int[] largestOnLeft = getLargestElementOnLeft(height);

        int maxWaterHold = 0;
        for(int i = 0; i < length; i++){
            int minElement = Math.min(largestOnRight[i], largestOnLeft[i]);
            if(minElement > height[i]){
                maxWaterHold += minElement - height[i];
            }
        }
        return maxWaterHold;
    }
    private int[] getLargestElementOnRight(int[] input){
        int[] largestOnRight = new int[input.length];
        int maxEncounterTillNow = -1;
        for(int i = input.length-1; i >= 0; i--){
            largestOnRight[i] = maxEncounterTillNow;
            maxEncounterTillNow = Math.max(maxEncounterTillNow, input[i]);
        }
        return largestOnRight;
    }
    private int[] getLargestElementOnLeft(int[] input){
        int[] largestOnLeft = new int[input.length];
        int maxEncounterTillNow = -1;
        for(int i = 0; i < input.length; i++){
            largestOnLeft[i] = maxEncounterTillNow;
            maxEncounterTillNow = Math.max(maxEncounterTillNow, input[i]);
        }
        return largestOnLeft;
    }
}
