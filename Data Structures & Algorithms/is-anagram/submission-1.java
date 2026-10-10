class Solution {
    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        if(sLength != tLength) return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < sLength; i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }

        return sMap.equals(tMap);
    }
}
