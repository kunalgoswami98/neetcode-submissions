class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencyArr = new int[26];
        for(char task: tasks){
            frequencyArr[task-'A'] += 1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for(int frequency : frequencyArr){
            if(frequency > 0) maxHeap.add(frequency);
        }
        System.out.println(maxHeap);
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if(maxHeap.isEmpty()){
                time = queue.peek()[1];
            }
            else {
                int count = maxHeap.poll() - 1;
                if(count > 0){
                    queue.add(new int[]{count,time+n});
                }
            }

            if(!queue.isEmpty() && time == queue.peek()[1]){
                maxHeap.add(queue.poll()[0]);
            }
        }
        return time;
    }
}
