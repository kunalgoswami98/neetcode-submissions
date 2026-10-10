class Solution {
    public boolean isPalindrome(String s) {
        int sLength = s.length();
        if(sLength == 0) return true;

        int startPointer = 0;
        int endPointer = s.length()-1;
        s = s.toLowerCase();
        while(startPointer <= endPointer){
            char startChar = s.charAt(startPointer);
            char endChar = s.charAt(endPointer);
            if(!Character.isLetterOrDigit(startChar)){
                startPointer++;
            }
            else if(!Character.isLetterOrDigit(endChar)){
                endPointer--;
            }
            else{
                if(startChar != endChar) return false;
                startPointer++;
                endPointer--;
            }
        }
        return true;
    }
}
