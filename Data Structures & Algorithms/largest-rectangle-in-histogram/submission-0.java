class Solution {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;

        int[] lessFromLeft = findLessOnLeft(heights);
        int[] lessFromRight = findLessOnRight(heights);

        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < length; i++){
            int currentArea = heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1 );
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
        
    }

    private int[] findLessOnLeft(int[] heights){
        int[] temp = new int[heights.length];
        temp[0] = -1;
        for(int i = 1; i < heights.length; i++){
            int prev = i - 1;

            while(prev >= 0 && heights[prev] >= heights[i]){
                prev = temp[prev];
            }
            temp[i] = prev;
        }
        return temp;
    }
    private int[] findLessOnRight(int[] heights){
        int[] temp = new int[heights.length];
        temp[heights.length-1] = heights.length;
        for(int i = heights.length-2; i >= 0; i--){
            int next = i + 1;

            while(next < heights.length && heights[next] >= heights[i]){
                next = temp[next];
            }
            temp[i] = next;
        }
        return temp;
    }
}