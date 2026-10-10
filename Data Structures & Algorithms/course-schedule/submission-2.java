class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            List<Integer> list = map.get(pre[1]);
            list.add(pre[0]);
            map.put(pre[1], list);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> pathVisited = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(containsCycle(i, map, visited, pathVisited)) return false;
        }
        return true;
    }

    private boolean containsCycle(int course, Map<Integer, List<Integer>> map, Set<Integer> visited, Set<Integer> pathVisited) {
        visited.add(course);
        pathVisited.add(course);

        List<Integer> neighbors = map.get(course);
        for(Integer neighbor: neighbors) {
            if(pathVisited.contains(neighbor)) return true;
            if(!visited.contains(neighbor) && containsCycle(neighbor, map, visited, pathVisited)) return true;
        }
        pathVisited.remove(course);
        return false;
    }
}
