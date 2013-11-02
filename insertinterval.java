/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    private int max(int a, int b){
        if (a > b) return a;
            else return b;
    }
    private int min(int a, int b){
        if (a < b) return a;
            else   return b;
    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // find the overlap range,remove the range and add new interval
        int head, tail;
        int n = intervals.size();
        head = 0;
        tail = n - 1;
        while( head <= tail){
            int mid = (head + tail) / 2;
            if(intervals.get(mid).end < newInterval.start)
                head = mid + 1;
            else
                tail = mid - 1;
        }
        int start_index = head;
        head = 0;
        tail = n - 1;
        while( head <= tail){
            int mid = (head + tail) / 2;
            if(intervals.get(mid).start <= newInterval.end)
                head = mid + 1;
            else
                tail = mid - 1;
        }
        int end_index = head;
        if ( start_index < end_index){
            // there is overlap of new interval and existing intervals
            newInterval.start = min(intervals.get(start_index).start, newInterval.start);
            newInterval.end = max(intervals.get(end_index - 1).end, newInterval.end);
            intervals.removeRange(start_index, end_index);
        }
        intervals.add(start_index, newInteval);
        return intervals;
        
    }
}
