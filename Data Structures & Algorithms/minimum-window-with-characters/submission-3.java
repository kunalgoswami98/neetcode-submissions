class Solution {
    public String minWindow(String s, String t) {
        int tLength = t.length();
        int sLength = s.length();
        if(tLength > sLength) return "";
        int start = 0;
        int end = 0;

        Map<Character, Integer> tFrequency = new HashMap<>();
        for(char ch : t.toCharArray()){
            tFrequency.put(ch, tFrequency.getOrDefault(ch,0)+1);
        }

        Map<Character, Integer> sFrequency = new HashMap<>();
        int startPoint = 0;
        int endPoint = 0;
        int resultLength = Integer.MAX_VALUE;
        int tCount = tFrequency.size();
        int sCount = 0;
        while(end < s.length()){
            char ch = s.charAt(end);
            sFrequency.put(ch, sFrequency.getOrDefault(ch,0)+1);
            if(tFrequency.containsKey(ch) && sFrequency.get(ch).equals(tFrequency.get(ch))){
                sCount++;
            }
            while(tCount == sCount){
                if(resultLength > (end - start + 1)){
                    resultLength = ((end - start + 1));
                    startPoint = start;
                    endPoint = end;
                }
                char startingChar = s.charAt(start);
                sFrequency.put(startingChar, sFrequency.get(startingChar)-1);
                if(tFrequency.containsKey(startingChar) && sFrequency.get(startingChar) < tFrequency.get(startingChar)){
                    sCount--;
                }
                start++;
            }
            end++;
        }
        return resultLength == Integer.MAX_VALUE ? "" : s.substring(startPoint,endPoint+1);
    }
}
