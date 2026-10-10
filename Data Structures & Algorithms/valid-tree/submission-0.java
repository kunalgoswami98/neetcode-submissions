class Solution {
    public boolean validTree(int n, int[][] edges) {
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
        boolean[] pathVisited = new boolean[n];
        //check if graph has no cycle
        if(findCycle(adjList, 0, visited, pathVisited, -1)){
            return false;
        
        }
        
        //check if every node is visited
        for(int i = 0; i < n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }

    private boolean findCycle(Map<Integer, List<Integer>> adjList, int node, boolean[] visited, boolean[] pathVisited, int parent) {


        visited[node] = true;
        pathVisited[node] = true;

        List<Integer> neighbors = adjList.get(node);
        for(Integer neighbor: neighbors){
            if(neighbor != parent && pathVisited[neighbor]) return true;
            if(!visited[neighbor] && findCycle(adjList, neighbor, visited, pathVisited, node)) return true;
        }

        pathVisited[node] = false;
        return false;
    }
}