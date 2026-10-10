class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int numbersLength = numbers.length;
        int start = 0;
        int end = numbers.length-1;
        int[] result = new int[2];

        while(start < end){
            int currentSum = numbers[start] + numbers[end];
            if(currentSum == target){
                result[0] = start+1;
                result[1] = end+1;
                break;
            }
            if(currentSum > target) end--;
            else start++;
        }
        return result;
    }
}
