class PrefixTree {
    class Trie{
        Trie[] node;
        String word;

        Trie(){
            node = new Trie[26];
        }
    }
    Trie root;
    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie temp = root;

        for(char ch: word.toCharArray()){
            if(temp.node[ch - 'a'] == null){
                temp.node[ch - 'a'] = new Trie();
            }
            temp = temp.node[ch-'a'];
        }
        temp.word = word;
    }

    public boolean search(String word) {
        Trie temp = root;

        for(char ch: word.toCharArray()){
            if(temp.node[ch-'a'] == null) return false;
            temp = temp.node[ch-'a'];
        }
        return temp.word != null && temp.word.equals(word);
    }

    public boolean startsWith(String prefix) {
        Trie temp = root;

        for(char ch: prefix.toCharArray()){
            if(temp.node[ch-'a'] == null) return false;
            temp = temp.node[ch-'a'];
        }
        return true;
    }
}
