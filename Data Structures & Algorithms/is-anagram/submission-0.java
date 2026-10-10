class Solution {
    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        if(sLength != tLength) return false;

        Map<Character,Integer> sFrequencyMap = new HashMap<>();
        Map<Character,Integer> tFrequencyMap = new HashMap<>();

        for(int i = 0; i < sLength; i++){
            sFrequencyMap.put(s.charAt(i), sFrequencyMap.getOrDefault(s.charAt(i),0)+1);
            tFrequencyMap.put(t.charAt(i), tFrequencyMap.getOrDefault(t.charAt(i),0)+1);
        }

        return sFrequencyMap.equals(tFrequencyMap);
    }
}
