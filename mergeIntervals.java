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
    public IntervalComparator implements Comparator<Interval>{
        public int compare(Interval i1, Interval i2){
            if (i1.start > i2.start) return 1;
            if (i1.start < i2.start) return -1;
            return 0;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (intervals.isEmpty())
            return intervals();

        Collections.sort(intervals, new IntervalComparator());
        ArrayList<Interval> answer = new ArrayList<Interval>();
        curr = intervals.get(0);
        for(int i = 1; i < intervals.size(); i ++){
            next = intervals.get(i);
            if (curr.end < next.begin){
                answer.add(curr);
                curr = next;
            }else{
                curr.end = Math.max(next.end, curr.end);
            }
        }
        answer.add(curr);
        return answer;
    }
}
