package LeetCode.second_0628;
/*
35. 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0
 */
public class Simple_35 {
//    public int searchInsert(int[] nums, int target) {
//        int i;
//        for (i = 0; i < nums.length; i++) {
//            if (target <= nums[i]) {
//                break;
//            }
//        }
//        return i;
//    }

    // 二分搜索
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int res = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((mid == 0 || target > nums[mid - 1]) && target <= nums[mid]) {
                res = mid;
                break;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (mid > 0 && target <= nums[mid - 1]) {
                right = mid - 1;
            }
        }
        if (left >= nums.length) {
            res = nums.length;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1,3,5,7
        };
        int target = 6;
        System.out.println(new Simple_35().searchInsert(nums, target));
    }
}
