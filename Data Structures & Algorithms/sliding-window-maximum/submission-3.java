class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length == 1) return new int[]{nums[0]};
        int start = 0;
        int end = 0;
        int totalResult = 1 + (nums.length-k);
        int[] result = new int[totalResult];
        int maxValueSoFar = Integer.MIN_VALUE;
        int indexOfMax = 0;
        while(end < k && end < length){
            if(maxValueSoFar < nums[end]){
                maxValueSoFar = nums[end];
                indexOfMax = end;
            }
            end++;
        }
        int index = 0;
        result[index++] = maxValueSoFar;
        start++;
        while(end < length){
            if(maxValueSoFar < nums[end]){
                maxValueSoFar = nums[end];
                indexOfMax = end;
            }
            else if(indexOfMax < start){
                int i = start;
                maxValueSoFar = Integer.MIN_VALUE;
                while(i <= end){
                    System.out.println(i+" : "+start+" : "+end);
                    if(maxValueSoFar < nums[i]){
                        maxValueSoFar = nums[i];
                        indexOfMax = i;
                    }
                    i++;
                }
            }
            result[index++] = maxValueSoFar;
            end++;
            start++;
        }
        return result;
    }
}
