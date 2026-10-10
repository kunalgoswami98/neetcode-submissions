class Solution {
    public int maxArea(int[] heights) {
        int length = heights.length;
        int maxWaterCapacity = Integer.MIN_VALUE;

        int start = 0;
        int end = length - 1;

        while(start < end){
            int area = (end - start) * (Math.min(heights[start], heights[end]));
            maxWaterCapacity = Math.max(area, maxWaterCapacity);
            if(heights[start] < heights[end]) start++;
            else end--;
        }
        return maxWaterCapacity;
    }
}
