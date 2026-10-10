class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> palindromicPart = new ArrayList<>();
        findPalindromicPartition(s,new ArrayList<>(), palindromicPart);
        return palindromicPart;
    }
    private void findPalindromicPartition(String s, List<String> part, List<List<String>> palindromicPart) {
        if(s == null || s.length() == 0){
            palindromicPart.add(new ArrayList<>(part));
            return;
        }

        for(int i = 1; i <= s.length(); i++) {
            String currentString = s.substring(0,i);
            if(!isPalindrome(currentString)) continue;
            part.add(currentString);
            findPalindromicPartition(s.substring(i,s.length()),part,palindromicPart);
            part.remove(part.size()-1);
        }
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while(start <= end){
            if(str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
