package com.lmw.sort;

/**
 * Created with IntelliJ IDEA.
 * User: lmw
 * Date: 2020/8/24 23:22
 * Description: 快速排序
 */
public class QuickSort {
    public int[] quickSort(int[] nums) {
        // 思路：把一个数组分为左右两段，左段小于右段，类似分治法没有合并过程
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            // pivot 是分割点，pivot左边的比nums[pivot]小，右边的比nums[pivot]大
            int pivot = partition(nums, start, end);
            quickSort(nums, 0, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int target = nums[end];
        int i = start;
        // 将小于target移到数组前面
        for (int j = start; j < end; j++) {
            if (nums[j] < target) {
                swap(nums, i, j);
                i++;
            }
        }
        // 把中间的值换为用于比较的基准值
        swap(nums, i, end);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}