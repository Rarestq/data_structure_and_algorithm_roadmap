package com.rarestzhou.leetcode_solutions.java.sorting;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2021/1/27 10:27
 * @description: 快排解法
 */
public class QuickSortSolutions {

    /**
     * 快速排序(哨兵优化)
     * 1、选择基准值（如何选择基准值决定了快排的时间复杂度）
     * 1.1、基准值每次都是当前区间的中间值时，操作数最少，时间复杂度为 O(n*log2^n)。
     * 1.2、基准值每次都是当前区间的最小值或最大值时，操作数最多，时间复杂度为 O(n^2)。
     * 2、分区，（从右往左遍历）小于基准值的放在基准值左边，反之放在右边，相等的无所谓
     * 3、对左右两个区间重复执行1，2步骤
     * <p>
     * 时间复杂度：最好，每次左右两个区间分布均匀-O(N*logN),但在数组中的元素已经有序的情况下，时间复杂度就退化为 O(N^2)，
     * 平均时间复杂度-O(N*logN)
     * 空间复杂度：O(1)
     *
     * @param arr
     */
    public void quickSort(int[] arr, int head, int tail) {
        int low = head;
        int high = tail;
        int pivot = arr[low];
        if (low < high) {
            while (low < high) {
                while (low < high && pivot <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && pivot >= arr[low]) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = pivot;

            if (low > head + 1) {
                quickSort(arr, head, low - 1);
            }
            if (high < tail - 1) {
                quickSort(arr, high + 1, tail);
            }
        }
    }

    /**
     * 原地排序思路（不稳定的排序算法）：
     * 1、对无序数组分区，并找到一个基准值
     *  1.1、先将数组最后一个元素定位基准值，然后通过游标从左往右遍历 [0,right-1]区间的数；
     *  1.2、小于基准值的放左边，大于基准值的放右边（通过交换的方式实现O(1)时间复杂度）
     *  1.3、最后交换基准值和此时游标所在位置元素
     * 2、同时对分区后的左右两个区间执行步骤1
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickPartitionSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        // 分区，并返回基准值位置
        int pivot = partition(arr, left, right);
        // 递归对基准值左右两个区间进行排序
        quickPartitionSort(arr, left, pivot - 1);
        quickPartitionSort(arr, pivot + 1, right);
    }

    /**
     * 分区（原地排序）
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] arr, int left, int right) {
        // 暂定数组最后一位为基准值（如何选择基准值也可优化）
        int pivot = arr[right];
        // 初始化游标为数组第一个元素所在位置
        int cursor = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                // 交换 cursor 和 i 所在位置元素
                int temp = arr[i];
                arr[i] = arr[cursor];
                arr[cursor] = temp;
                // 游标向右移动
                cursor++;
            }
        }
        // 循环完后，此时游标 cursor 所在位置元素刚好是大于 pivot 元素区间的第一个元素，交换即可
        arr[right] = arr[cursor];
        arr[cursor] = pivot;
        return cursor;
    }

    public void topK(int[] arr) {

    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 11, 3, 12, 7, 7, 9, 8};
        for (int i : arr) {
            System.out.println(i);
        }
        int head = 0;
        int tail = arr.length - 1;
        quickPartitionSort(arr, head, tail);
        System.out.println("========");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
