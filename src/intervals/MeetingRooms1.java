package intervals;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms/
public class MeetingRooms1 {
    public static void main(String[] args) {

    }
}

// Input: intervals = [[0,30],[5,10],[15,20]]
//     Output: false
//
// Input: intervals = [[7,10],[2,4]]
//    Output: true

// sort meetings as per start time then
// check prev meeting end time > curr start time then it is overlapping
class MeetingRooms1_Optimal_Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }

        return true;
    }
}
