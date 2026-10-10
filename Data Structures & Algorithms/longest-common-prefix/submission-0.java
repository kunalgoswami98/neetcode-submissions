class Solution {
    class Trie{
        Trie[] node;

        Trie(){
            node = new Trie[26];
        }
    }
    Trie head;
    int maxLength;
    public String longestCommonPrefix(String[] strs) {
        head = new Trie();
        int length = strs.length;
        if(length == 0) return "";
        maxLength = strs[0].length();
        createTrie(strs[0]);
        for(int i = 1; i < strs.length; i++){
            checkMaxInTrie(strs[i]);
            if(maxLength == 0) return "";
        }
        return strs[0].substring(0,maxLength);
    }

    private void checkMaxInTrie(String str) {
        Trie temp = head;
        int maxParse = 0;
        for(char ch: str.toCharArray()){
            if(temp.node[ch - 'a'] == null){
                maxLength = Math.min(maxParse, maxLength);
                return;
            }
            temp = temp.node[ch - 'a'];
            maxParse++;
        }
        maxLength = Math.min(maxParse, maxLength);
    }
    private void createTrie(String str){
        Trie temp = head;

        for(char ch : str.toCharArray()){
            if(temp.node[ch-'a'] == null){
                temp.node[ch - 'a'] = new Trie();
            }
            temp = temp.node[ch - 'a'];
        }
    }
}