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
//        int pivot = partition(arr, left, right);
        // 递归对基准值左右两个区间进行排序
//        quickPartitionSort(arr, left, pivot - 1);
//        quickPartitionSort(arr, pivot + 1, right);

        // 快排优化一：单边递归优化
        singleSideQuickPartitionSort(arr, left, right);
    }

    /**
     * 快排优化一：单边递归优化（对程序的实际运行时间做的优化）
     *
     * partition 分区后，在对基准值左右两边进行递归调用排序的时候，可以尝试减少调用此时
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void singleSideQuickPartitionSort(int[] arr, int left, int right) {
        while (left < right) {
            // 进行一轮 partition 操作
            // 获得基准值的位置
            int ind = partition(arr, left, right);
            // 右侧正常调用递归函数
            singleSideQuickPartitionSort(arr, ind  +1, right);
            // 用本层处理左侧的排序
            right = ind - 1;
        }
    }

    /**
     * 快排优化二：基准值选取优化（三点取中法）--> 使快速排序的时间复杂度尽量稳定在O(N*logN)二提出来的
     *
     * 只有当基准值每次都能(尽可能)将排序区间中的数据平分时，时间复杂度才是最好情况下的 O(N*logN)，
     * 不然就可能退化为和选择排序、插入排序一样的时间复杂度O(N^2)
     *
     * 三点取中法：每一轮取排序区间的头、尾和中间元素这三个值，然后把它们排序以后的中间值作为本轮的基准值
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void selectPivot(int[] arr, int left, int right) {

    }

    /**
     * 快排优化三：partition 操作优化（对程序的实际运行时间做的优化）
     *
     * partition 的实现过程：先从后向前找个小于基准值的数字放到前面，再从前向后找个大于基准值的数字放到后面，直到首尾指针相遇为止
     *
     * 基准值的客观位置不变，红色与绿色元素数量是确定的，所以存在多少个绿色元素在基准值位置的后面，就一定存在多少个红色元素在基准值位置的前面
     *
     * 那 partition 操作的目的，就是要把基准值位置后面的绿色元素调整到前面，将基准值位置前面的红色元素调整到后面。
     * 既然需要调换的红色与绿色元素的数量相同，我们就可以让头指针向后查找红色元素，尾指针向前查找绿色元素，然后交换头尾指针所指向的元素，
     * 重复这个过程，直到头尾指针交错后停止。这就是对 partition 操作进行的优化
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void partitionOptimize(int[] arr, int left, int right) {

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
