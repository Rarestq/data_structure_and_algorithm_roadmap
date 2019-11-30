package com.rarestzhou.leetcode_solutions.array;

/**
 * 88. Merge Sorted Array
 * <p>
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author: wuxiu
 * @date: 2019/11/28 19:34
 */
public class MergeSortedArraySolutions {

    /**
     * 解法一：简单粗暴法
     * 用两个指针 i 和 j ，i 指向 nums1 当前判断的数字，j 指向 num2 当前遍历的数字。
     * 如果 j 指向的数字小于 i 指向的数字，那么就做插入操作。否则的话后移 i ，找到需要插入的位置。
     *
     * 时间复杂度：极端情况下，如果每次都需要插入，那么是 O（n²）。
     * 空间复杂度：O（1）。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        // 遍历 nums2
        while (j < n) {
            // 判断 nums1 是否遍历完
            //（nums1 原有的数和当前已经插入的数相加）和 i 进行比较
            if (i == m + j) {
                //将剩余的 nums2 插入
                while (j < n) {
                    nums1[m + j] = nums2[j];
                    j++;
                }
                return;
            }
            // 判断当前 nums2 是否小于 nums1
            if (nums2[j] < nums1[i]) {
                //nums1 后移数组，空出位置以便插入
                for (int k = m + j; k > i; k--) {
                    nums1[k] = nums1[k - 1];
                }
                nums1[i] = nums2[j];
                // i 和 j 后移
                j++;
                i++;
                // 当前 nums2 不小于 nums1， i 后移
            } else {
                i++;
            }
        }
    }

    /**
     * 解法二：归并排序的思想
     *  把 nums1 当作合并后的大数组，依次从两个数组中选较小的数。同时，为了防止 nums1 原有的数字被覆盖，先把原有的数字放到大数组末尾。
     *
     * 时间复杂度： O（n）。
     * 空间复杂度：O（1）。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 将 nums1 的数字全部移动到末尾
        for (int count = 1; count <= m; count++) {
            nums1[m + n - count] = nums1[m - count];
        }

        // i 从 n 开始
        int i = n;
        int j = 0;
        int k = 0;
        // 遍历 nums2
        while (j < n) {
            // 如果 nums1 遍历结束，将 nums2 直接加入
            if (i == m + n) {
                while (j < n) {
                    nums1[k++] = nums2[j++];
                }
                return;
            }
            // 哪个数小就对应的添加哪个数
            if (nums2[j] < nums1[i]) {
                nums1[k] = nums2[j++];
            } else {
                nums1[k] = nums1[i++];
            }
            k++;
        }
    }

    /**
     * 解法三：leetcode discuss 里大神的回答
     *
     * @link https://leetcode.com/problems/merge-sorted-array/discuss/29522/This-is-my-AC-code-may-help-you
     *
     * 时间复杂度： O（n）。
     * 空间复杂度：O（1）
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 从末尾开始
        int i = m - 1;
        // 从末尾开始
        int j = n - 1;
        // 从末尾开始
        int k = m + n - 1;
        while (j >= 0) {
            if (i < 0) {
                while (j >= 0) {
                    nums1[k--] = nums2[j--];
                }
                return;
            }
            // 哪个数大就对应的添加哪个数。
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
