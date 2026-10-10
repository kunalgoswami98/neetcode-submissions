class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            int[] count = new int[26];
            for(char ch: str.toCharArray()){
                count[ch - 'a']++;
            }

            StringBuilder strBuild = new StringBuilder();
            for(int c: count){
                strBuild.append('#').append(c);
            }
            map.computeIfAbsent(strBuild.toString(), k -> new ArrayList()).add(str);
        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
}
