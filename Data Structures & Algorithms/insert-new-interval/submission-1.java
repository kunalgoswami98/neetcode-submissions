class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;

        List<int[]> mergeIntervals = new ArrayList<>();

        //traverse through non-overlaping intervals before new Interval
        int index = 0;
        while(index < length && intervals[index][1] < newInterval[0]){
            mergeIntervals.add(new int[]{intervals[index][0],intervals[index][1]});
            index++;
        }
        //traverse through overlapping intervals
        while(index < length && intervals[index][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        mergeIntervals.add(new int[]{newInterval[0], newInterval[1]});
        //traverse through non-overlapping intervals after merging new interval
        while(index < length){
            mergeIntervals.add(new int[]{intervals[index][0],intervals[index][1]});
            index++;
        }

        return mergeIntervals.toArray(new int[mergeIntervals.size()][]);
    }
}
