package Sort_Algorithm;

import java.util.Arrays;

public class QuickSort3 {
    // 快速排序优雅版
    public int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        //对特殊值和边界值的检查，提高程序的鲁棒性
        if (nums == null || left < 0) {
            return;
        }
        if (left < right) {
            int index = partition(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot)
                right--;
            if (left < right)
                nums[left++] = nums[right];
            while (left < right && nums[left] <= pivot)
                left++;
            if (left < right)
                nums[right--] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        System.out.println(Arrays.toString(new QuickSort3().sort(nums)));
    }
}
