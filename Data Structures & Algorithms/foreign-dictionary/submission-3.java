class Solution {
    public String foreignDictionary(String[] words) {
        int length = words.length;


        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        //form adjList
        for(int i = 0; i < length; i++){
            for(int j = 0; j < words[i].length(); j++){
                adjList.putIfAbsent(words[i].charAt(j), new ArrayList<>());
                indegree.putIfAbsent(words[i].charAt(j), 0);
            }
        }
        for(int i = 0; i < length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int minLength = Math.min(word1.length(), word2.length());
            if(word1.length() > word2.length() &&
            word1.substring(0,minLength).equals(word2.substring(0,minLength))){
                return "";
            }

            for(int j = 0; j < minLength; j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    indegree.put(word2.charAt(j), indegree.get(word2.charAt(j))+1);
                    // System.out.println(word1.charAt(j)+" one : "+word2.charAt(j)+" : "+indegree);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        Set<Character> alreadyVisited = new HashSet<>();
        for(Character ch: indegree.keySet()){
            if(indegree.get(ch) == 0){
                queue.add(ch);
            }
        }

        if(queue.isEmpty()) return "";
        while(!queue.isEmpty()) {
            Character currentChar = queue.remove();
            if(alreadyVisited.contains(currentChar)) return "";
            builder.append(currentChar);
            for(Character ch: adjList.get(currentChar)){
                indegree.put(ch, indegree.get(ch)-1);
                if(indegree.get(ch) == 0) queue.add(ch);
            }
        }
        if(indegree.size() != builder.length()) return "";
        return builder.toString();
    }
}
/**

*/