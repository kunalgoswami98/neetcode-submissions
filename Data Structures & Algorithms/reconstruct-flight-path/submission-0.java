class Solution {
    List<String> result;
    Map<String, PriorityQueue<String>> adjList;
    public List<String> findItinerary(List<List<String>> tickets) {
        adjList = new HashMap<>();
        result = new ArrayList<>();
        for(List<String> iternary: tickets){
            if(!adjList.containsKey(iternary.get(0))){
                adjList.put(iternary.get(0), new PriorityQueue<>());
            }
            adjList.get(iternary.get(0)).add(iternary.get(1));
        }
        dfs("JFK");
        return result;
    }
    private void dfs(String currentNode){
        PriorityQueue<String> pQueue = adjList.get(currentNode);
        while(pQueue != null && pQueue.size() > 0){
            dfs(pQueue.remove());
        }
        result.add(0,currentNode);
        
    }
}