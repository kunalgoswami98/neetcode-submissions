class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(arr[start])) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(arr[end])) {
                end--;
                continue;
            }
            if (arr[start] != arr[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}
