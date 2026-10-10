/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        //sort list
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        int meetingRooms = 0;
        PriorityQueue<Integer> currentMeetings = new PriorityQueue<>();
        for(Interval interval: intervals){
            while(!currentMeetings.isEmpty() && currentMeetings.peek() <= interval.start){
                currentMeetings.remove();
            }
            currentMeetings.add(interval.end);
            meetingRooms = Math.max(meetingRooms, currentMeetings.size());
        }
        return meetingRooms;
    }
}
