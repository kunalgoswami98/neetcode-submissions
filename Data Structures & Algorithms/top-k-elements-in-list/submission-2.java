class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pQueue = new PriorityQueue<>(
            (a,b) -> a.getValue() - b.getValue()
        );

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            pQueue.add(entry);
            if(pQueue.size() > k) pQueue.remove();
        }
        int[] result = new int[pQueue.size()];
        int index = 0;
        while(!pQueue.isEmpty()){
            result[index++] = pQueue.remove().getKey();
        }
        return result;
    }
}
