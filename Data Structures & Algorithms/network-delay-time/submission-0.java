class Solution {
    class Pair{
        int node;
        int distance;

        Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        //using Dikstras algorithm

        Map<Integer, List<Pair>> adjList = new HashMap<>();

        for(int node = 1; node <= n; node++){
            adjList.put(node, new ArrayList<>());
        }
        for(int index = 0; index < times.length; index++){
            adjList.get(times[index][0]).add(new Pair(times[index][1], times[index][2]));
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        minHeap.add(new int[]{k,0});
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        while(!minHeap.isEmpty()){
            int[] currentEntry = minHeap.remove();
            List<Pair> neighbors = adjList.get(currentEntry[0]);

            for(Pair p : neighbors){
                int neighborNode = p.node;
                int neighborDistance = p.distance;
                if(distance[neighborNode] > currentEntry[1] + neighborDistance){
                    distance[neighborNode] = currentEntry[1] + neighborDistance;
                    minHeap.add(new int[]{neighborNode, distance[neighborNode]});
                }
            }
        }

        int minNetworkDelay = Integer.MIN_VALUE;
        
        for(int index = 1; index <= n; index++){
            if(distance[index] == Integer.MAX_VALUE) return -1;
            minNetworkDelay = Math.max(minNetworkDelay, distance[index]);
        }

        return minNetworkDelay;
    }
}