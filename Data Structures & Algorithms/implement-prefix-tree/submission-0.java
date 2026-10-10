class PrefixTree {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;


    }
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for(char ch : word.toCharArray()){
            if(temp.children[ch-'a'] == null){
                temp.children[ch-'a'] = new TrieNode();
            }
            temp = temp.children[ch-'a'];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for(char ch : word.toCharArray()){
            if(temp.children[ch-'a'] == null){
                return false;
            }
            temp = temp.children[ch-'a'];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(char ch: prefix.toCharArray()){
            if(temp.children[ch-'a'] == null) return false;
            temp = temp.children[ch-'a'];
        }
        return true;
    }
}
