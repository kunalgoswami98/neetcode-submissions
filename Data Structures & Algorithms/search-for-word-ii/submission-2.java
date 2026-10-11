class Solution {
    class Trie{
        Trie[] node;
        String word;

        Trie(){
            node = new Trie[26];
        }
    }
    Set<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        int rLength = board.length;
        int cLength = board[0].length;

        Trie root = new Trie();
        for(String word: words){
            buildTrie(root, word);
        }
        result = new HashSet<>();
        for(int i = 0; i < rLength; i++){
            for(int j = 0; j < cLength; j++){
                char ch = board[i][j];
                if(root.node[ch - 'a'] != null){
                    Trie temp = root;
                    dfs(board, i, j, temp.node[ch-'a']);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int row, int col, Trie root){
        if(root.word != null) result.add(root.word);

        int[] rowChanger = {-1,0,1,0};
        int[] colChanger = {0,-1,0,1};
        char originalChar = board[row][col];
        board[row][col] = '#';
        for(int i = 0; i < 4; i++){
            int newRow = row + rowChanger[i];
            int newCol = col + colChanger[i];
            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && board[newRow][newCol] != '#'){
                char ch = board[newRow][newCol];
                if(root.node[ch - 'a'] != null) {
                    dfs(board, newRow, newCol, root.node[ch-'a']);
                }
            }
        }
        board[row][col] = originalChar;
    }
    private void buildTrie(Trie root, String word){
        Trie temp = root;
        for(char ch: word.toCharArray()){
            if(temp.node[ch - 'a'] == null){
                temp.node[ch - 'a'] = new Trie();
            }
            temp = temp.node[ch - 'a'];
        }
        temp.word = word;
    }
}
