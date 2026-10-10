class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int start = 0;
        int end = 0;
        int rooms = 0;
        int maxRooms = 0;

        while (start < n) {
            if (starts[start] < ends[end]) {
                // New meeting starts before the earliest meeting ends
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                start++;
            } else {
                // A meeting has ended, free its room
                rooms--;
                end++;
            }
        }

        return maxRooms;
    }
}