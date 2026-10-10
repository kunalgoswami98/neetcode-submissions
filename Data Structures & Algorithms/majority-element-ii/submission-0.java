class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int length = nums.length;
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int key: freqMap.keySet()){
            if(freqMap.get(key) > length/3){
                list.add(key);
            }
        }
        return list;
    }
}