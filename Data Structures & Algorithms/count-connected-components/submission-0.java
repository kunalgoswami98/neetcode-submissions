class Solution {
    public int countComponents(int n, int[][] edges) {
        int rowLength = edges.length;
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }
        
        for(int row = 0; row < rowLength; row++){
            adjList.get(edges[row][0]).add(edges[row][1]);
            adjList.get(edges[row][1]).add(edges[row][0]);
        }

        boolean[] visited = new boolean[n];
        int numberOfConnectedComponent = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                numberOfConnectedComponent++;
                traverseDFS(adjList, i, visited);
            }
        }

        return numberOfConnectedComponent;
    }

    private void traverseDFS(Map<Integer, List<Integer>> adjList, int node, boolean[] visited){
        visited[node] = true;

        List<Integer> neighbors = adjList.get(node);

        for(Integer neighbor : neighbors){
            if(!visited[neighbor]){
                traverseDFS(adjList, neighbor, visited);
            }
        }
    }
}