class Solution {
    public int characterReplacement(String s, int k) {
        int length = s.length();

        int start = 0;
        int maxFrequency = 0;
        int result = 0;
        Map<Character, Integer> characterToFreqMap = new HashMap<>();
        for(int end = 0; end < length; end++){
            char currentChar = s.charAt(end);
            characterToFreqMap.put(currentChar,
                characterToFreqMap.getOrDefault(currentChar,0)+1);
            maxFrequency = Math.max(maxFrequency, 
                characterToFreqMap.get(currentChar));
            
            while((end - start + 1) - maxFrequency > k){
                characterToFreqMap.put(s.charAt(start), 
                    characterToFreqMap.get(s.charAt(start))-1);
                start++;
            }
            result = Math.max(result, (end-start+1));
        }
        return result;
    }
}
