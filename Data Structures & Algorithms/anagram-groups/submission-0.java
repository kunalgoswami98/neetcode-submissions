class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int strsLength = strs.length;
        if(strsLength == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strsLength; i++){
            char[] currentString = strs[i].toCharArray();
            Arrays.sort(currentString);
            String sortedString = new String(currentString);
            if(map.containsKey(sortedString)){
                List<String> list = map.get(sortedString);
                list.add(strs[i]);
                map.put(sortedString,list);
            }
            else{
                List<String> strList = new ArrayList<>();
                strList.add(strs[i]);
                map.put(sortedString, strList);
            }
        }

        List<List<String>> groupAnagramList = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            groupAnagramList.add(entry.getValue());
        }

        return groupAnagramList;
    }
}
