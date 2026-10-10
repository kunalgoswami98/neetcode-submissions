class Solution {
    class Tuple{
        int node;
        int dist;

        Tuple(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int rows = flights.length;
        
        Map<Integer, List<Tuple>> adjList = new HashMap<>();
        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int i = 0; i < rows; i++){
            adjList.get(flights[i][0]).add(new Tuple(flights[i][1], flights[i][2]));
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(src,0));
        int step = -1;
        while(!queue.isEmpty()){
            if(step == k) break;
            int size = queue.size();
            while(size-- > 0){
                Tuple tuple = queue.remove();
                List<Tuple> neighbors = adjList.get(tuple.node);

                for(Tuple nTuple: neighbors){
                    int totalDistance = tuple.dist + nTuple.dist;
                    if(distance[nTuple.node] > totalDistance){
                        distance[nTuple.node] = totalDistance;
                        queue.add(new Tuple(nTuple.node, totalDistance));
                    }
                }
            }
            step++;
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}