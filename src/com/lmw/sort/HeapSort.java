package com.lmw.sort;

/**
 * Created with IntelliJ IDEA.
 * User: lmw
 * Date: 2020/8/24 23:24
 * Description: 堆排序
 */
public class HeapSort {

    public void heapSort(int[] nums) {
        int i;
        int temp;
        int n = nums.length - 1;

        //建立初始堆,使跟结点最大也就是a[0]最大
        for (i = n / 2; i >= 0; --i) {
            move(nums, i, n);
        }

        //进行n-1次循环，完成堆排序
        for (i = n; i >= 1; --i) {
            // 以下3句换出了根结点中的关键字，将其放入最终位置
            temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            //在减少了一个关键字的无序序列中进行调整
            move(nums, 0, i - 1);
        }
    }


    /**
     * 在数组a[low]和a[high]的范围内对位置low上的结点进行调整
     *
     * @param nums nums
     * @param low  low
     * @param high high
     */
    private void move(int[] nums, int low, int high) {
        // a[]中是一棵完全二叉树 ，所以关键字的存储必须从0开始或者从1开始都可以，从1开始做孩子为2*
        int i = low, j = 2 * i + 1;

        //a[j]是a[i]的左孩子结点
        int temp = nums[i];
        while (j <= high) {
            //若右孩子较大，则把j指向右孩子
            if (j < high && nums[j] < nums[j + 1]) {
                // j变为2*i+1
                ++j;
            }
            if (temp < nums[j]) {
                //将a[j]调整到双亲结点的位置上
                nums[i] = nums[j];
                //修改i和j的值，以便继续向下调整
                i = j;
                j = 2 * i + 1;
            } else {
                break;
            }
        }
        //被调整结点的值放入最终位置
        nums[i] = temp;
    }
}