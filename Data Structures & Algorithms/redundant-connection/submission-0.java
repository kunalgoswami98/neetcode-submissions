class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int rowLength = edges.length;
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < rowLength; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            boolean[] visited = new boolean[rowLength];

            if(isConnected(edge[0]-1, edge[1]-1, visited, adjList)){
                return new int[]{edge[0], edge[1]};
            }

            adjList.get(edge[0]-1).add(edge[1]-1);
            adjList.get(edge[1]-1).add(edge[0]-1);
        }
        return new int[0];
    }

    private boolean isConnected(int src, int dest, boolean[] visited, Map<Integer, List<Integer>> adjList){
        visited[src] = true;

        if(src == dest){
            return true;
        }
        List<Integer> neighbors = adjList.get(src);

        for(Integer neighbor : neighbors){

            if(!visited[neighbor] && isConnected(neighbor, dest, visited, adjList)){
                return true;
            }

        }

        return false;
    }
}