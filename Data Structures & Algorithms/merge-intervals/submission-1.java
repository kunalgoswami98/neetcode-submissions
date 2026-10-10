class Solution {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> mergedIntervals = new ArrayList<>();
    
        for(int i = 1; i < length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end,intervals[i][1]);
            }
            else{
                //push
                mergedIntervals.add(new int[]{start,end});
                //change start and end pointers
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        mergedIntervals.add(new int[]{start,end});
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
