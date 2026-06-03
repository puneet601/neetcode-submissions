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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (i1,i2)-> Integer.compare(i1.start,i2.start));
        for(int i=0;i<intervals.size()-1;i++){
            Interval i1 = intervals.get(i);
            Interval i2 = intervals.get(i+1);

            if(i1.end>i2.start)
            return false;

            if(i1.start==i2.start)
            return false;
        }

        return true;
    }
}
