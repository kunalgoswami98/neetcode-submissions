class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length == 0) return 0;
        if(length == 1) return 1;

        Map<Character, Integer> charToIndexMap = new HashMap<>();
        int maxLongestSubstring = 0;
        int starting = 0;
        int end = 0;
        for(int i = 0; i < length; i++){
            char currentChar = s.charAt(i);
            if(charToIndexMap.containsKey(currentChar) &&
                charToIndexMap.get(currentChar) >= starting){
                    starting = charToIndexMap.get(currentChar) + 1;
            }
            else{
                end = i;
            }
            charToIndexMap.put(currentChar,i);
            maxLongestSubstring = Math.max(maxLongestSubstring, (end - starting + 1));
        }
        return maxLongestSubstring;
    }
}
