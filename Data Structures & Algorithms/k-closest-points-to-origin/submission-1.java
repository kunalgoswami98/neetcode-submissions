class Solution {
    class Metadata{
        int row;
        int col;
        double distance;

        Metadata(int row, int col, double distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Metadata> minHeap = new PriorityQueue<>((a,b) -> Double.compare(b.distance,a.distance));

        for(int[] point: points){
            double dist = Math.sqrt((point[0]*point[0]) + (point[1] * point[1]));
            minHeap.offer(new Metadata(point[0], point[1], dist));
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while(!minHeap.isEmpty()){
            result[index][0] = minHeap.peek().row;
            result[index][1] = minHeap.peek().col;
            index++;
            minHeap.poll();
        }
        return result;
    }
}
