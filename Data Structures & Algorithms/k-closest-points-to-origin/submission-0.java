class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int length = points.length;
        if(k == 0 || length == 0) return new int[0][0];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[0] - b[0]);

        for(int[] point: points){
            int distance = point[0] * point[0] + point[1] * point[1];
            minHeap.add(new int[]{distance,point[0],point[1]});
        }

        int[][] kClosestPoints = new int[k][2];

        for(int index = 0; index < k; index++){
            int[] closest = minHeap.remove();
            kClosestPoints[index] = new int[]{closest[1],closest[2]};
        }
        return kClosestPoints;
    }
}
