package intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public static void main(String[] args) {

    }
}

// Example 1:
//
// Input: intervals = [[0,30],[5,10],[15,20]]
// Output: 2
//
// Example 2:
//
// Input: intervals = [[7,10],[2,4]]
// Output: 1

class MeetingRooms2_Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> allocator =
                new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }
}