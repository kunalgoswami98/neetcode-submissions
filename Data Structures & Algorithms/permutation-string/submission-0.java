class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        Map<Character, Integer> s1Frequency = 
            new HashMap<>();
        Map<Character,Integer> s2Frequency = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            s1Frequency.put(s1.charAt(i),
                s1Frequency.getOrDefault(s1.charAt(i),0)+1);
            s2Frequency.put(s2.charAt(i),
                s2Frequency.getOrDefault(s2.charAt(i),0)+1);
        }
        int start = 0;
        int end = start + s1.length() -1;
        while(end < s2.length()){
            System.out.println(start+" : "+end+" : "+s2Frequency);
            if(s2Frequency.equals(s1Frequency)){
                return true;
            }
            s2Frequency.put(s2.charAt(start),s2Frequency.getOrDefault(s2.charAt(start),0)-1);
            if(s2Frequency.get(s2.charAt(start)) == 0) s2Frequency.remove(s2.charAt(start));
            start++;
            end++;
            if(end < s2.length())
                s2Frequency.put(s2.charAt(end),s2Frequency.getOrDefault(s2.charAt(end),0)+1);
        }
        return false;
    }
}
