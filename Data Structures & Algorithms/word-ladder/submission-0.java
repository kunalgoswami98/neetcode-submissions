class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 1;

        //dictionary for O(1) lookup
        Set<String> dictionary = new HashSet<>();

        for(String word : wordList){
            dictionary.add(word);
        }

        //visited set
        Set<String> visitedWords = new HashSet<>();

        //Queue for BFS of words
        Queue<String> queue = new LinkedList<>();
        
        //add start word to the queue and make it visited
        queue.add(beginWord);
        visitedWords.add(beginWord);
        //step of word change
        int step = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String currentWord = queue.remove();
                if(currentWord.equals(endWord)) return step;
                char[] currentWordArr = currentWord.toCharArray();
                
                //traverse each character of the current word and add characters from 'a' to 'z' and check if available in dictionary
                for(int i = 0; i < currentWordArr.length; i++){
                    char currentChar = currentWordArr[i];
                    for(int j = 'a' ; j <= 'z'; j++){
                        char ch = (char)j;
                        currentWordArr[i] = ch;
                        String newStr = new String(currentWordArr);
                        if(!visitedWords.contains(newStr) && dictionary.contains(newStr)){
                            queue.add(newStr);
                            visitedWords.add(newStr);
                        }
                    }
                    currentWordArr[i] = currentChar;
                }
            }
            step++;
        }

        return 0;
    }
}