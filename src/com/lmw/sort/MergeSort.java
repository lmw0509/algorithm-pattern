package com.lmw.sort;

/**
 * Created with IntelliJ IDEA.
 * User: lmw
 * Date: 2020/8/24 23:23
 * Description: 归并排序
 */
public class MergeSort {
    public int[] mergeSortRoot(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            // 分治
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            // 合并
            merge(nums, l, mid, r);
        }
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int i = l, j = mid + 1, k = l;
        int[] tmp = new int[nums.length];
        while (i <= mid && j <= r) {
            if (nums[i] > nums[j]) {
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }
        for (i = l; i <= r; i++) {
            nums[i] = tmp[i];
        }
    }
}