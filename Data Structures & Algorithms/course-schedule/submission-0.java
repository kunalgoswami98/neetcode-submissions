class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            adjList.put(i,new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean[] pathVisited = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(findCycle(i, adjList, pathVisited, visited)) return false;
        }
        return true;
    }

    private boolean findCycle(int currentNode, Map<Integer, List<Integer>> adjList, boolean[] pathVisited, boolean[] visited) {
        pathVisited[currentNode] = true;
        visited[currentNode] = true;

        List<Integer> adjNodes = adjList.get(currentNode);

        for(int i = 0; i < adjNodes.size(); i++){
            if(pathVisited[adjNodes.get(i)] == true) return true;
            if(!visited[adjNodes.get(i)] && findCycle(adjNodes.get(i), adjList, pathVisited, visited)) return true;
        }

        pathVisited[currentNode] = false;
        return false;
    }
}