class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++; 
        }

        for(int i = 0 ; i < numCourses; i++){
            adjList.put(i,new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < indegree.length; i++){
            if(indegree[i] == 0) queue.add(i);
        }
        int totalIteratedCourses = 0;
        int[] result = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            totalIteratedCourses++;
            result[index++] = currentNode;

            List<Integer> adjNodes = adjList.get(currentNode);

            for(int i = 0; i < adjNodes.size(); i++){
                int node = adjNodes.get(i);
                indegree[node]--;
                if(indegree[node] == 0) queue.add(node);
            }
        }

        return totalIteratedCourses == numCourses ? result : new int[0];
    }
}