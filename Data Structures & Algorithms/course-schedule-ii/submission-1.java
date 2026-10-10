class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //BFS
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int[] pre: prerequisites) {
            List<Integer> list = adjList.get(pre[1]);
            list.add(pre[0]);
            indegree[pre[0]]++;
            adjList.put(pre[1], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) queue.add(i);
        }
        int courses = 0;
        int[] result = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            courses++;
            int course = queue.remove();
            result[index++] = course;
            List<Integer> neighbors = adjList.get(course);
            for(Integer neighbor: neighbors){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) queue.add(neighbor);
            }
        }
        return courses == numCourses ? result : new int[0];
    }
}
