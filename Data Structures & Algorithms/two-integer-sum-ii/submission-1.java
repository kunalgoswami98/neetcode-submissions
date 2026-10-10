class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int numbersLength = numbers.length;
        int start = 0;
        int end = start+1;
        int[] result = new int[2];

        while(end < numbersLength){
            int currentSum = numbers[start] + numbers[end];
            if(currentSum == target){
                result[0] = start+1;
                result[1] = end+1;
                break;
            }
            else if(currentSum > target || end == numbersLength-1){
                start = start+1;
                end = start+1;
            }
            else{
                end++;
            }
        }
        return result;
    }
}
