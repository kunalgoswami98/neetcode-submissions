class Solution {
    class Pair{
        int value;
        int frequency;

        Pair(int value, int frequency){
            this.value = value;
            this.frequency = frequency;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int numsLength = nums.length;

        //if length = 0 return empty array
        if(numsLength == 0) return new int[k];
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < numsLength; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        Queue<Pair> pQueue = new PriorityQueue<>((p1, p2) -> p1.frequency - p2.frequency);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pQueue.add(new Pair(entry.getKey(), entry.getValue()));
            if(pQueue.size() > k){
                pQueue.poll();
            }
        }
        int[] topKElementsArr = new int[k];
        int index = 0;
        while(!pQueue.isEmpty()){
            // Pair p = pQueue.poll();
            topKElementsArr[index++] = pQueue.poll().value;
        }
        return topKElementsArr;
    }
}
