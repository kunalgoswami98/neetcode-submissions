class Solution {
    public boolean validPalindrome(String s) {
        int start= 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return isPalindrome(s.substring(0,start)+s.substring(start+1)) ||
                isPalindrome(s.substring(0,end)+s.substring(end+1));
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isPalindrome(String str){
        int start = 0;
        int end = str.length()-1;

        while(start < end){
            if(str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}