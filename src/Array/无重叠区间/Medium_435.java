package Array.无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

/*
435. 无重叠区间
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
示例 1:

输入: [ [1,2], [2,3], [3,4], [1,3] ]

输出: 1

解释: 移除 [1,3] 后，剩下的区间没有重叠。
示例 2:

输入: [ [1,2], [1,2], [1,2] ]

输出: 2

解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
示例 3:

输入: [ [1,2], [2,3] ]

输出: 0

解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class Medium_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int res = 0;
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= max) {
                min = intervals[i][0];
                max = intervals[i][1];
            } else if (intervals[i][0] >= min && intervals[i][1] <= max) {
                min = intervals[i][0];
                max = intervals[i][1];
                res++;
            } else {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] intervals = {
//                {1,2},
//                {2,3},
//                {3,4},
//                {1,3}
//        };
        int[][] intervals = {
                {1,2},
                {2,3}
        };
        System.out.println(new Medium_435().eraseOverlapIntervals(intervals));
    }
}
