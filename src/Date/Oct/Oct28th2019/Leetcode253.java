package Date.Oct.Oct28th2019;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by apple on 10/28/19.
 */

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Leetcode253 {

    /**
     * lintcode: https://www.lintcode.com/problem/meeting-rooms-ii/description
     * @param intervals
     * @return
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.size() == 0) return 0;

        int count = 0;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Interval interval: intervals) {
            pq.add(interval.end);
            if (interval.start < pq.peek()) {
                count++;
            } else {
                pq.poll();
            }
        }
        return count;
    }
}
