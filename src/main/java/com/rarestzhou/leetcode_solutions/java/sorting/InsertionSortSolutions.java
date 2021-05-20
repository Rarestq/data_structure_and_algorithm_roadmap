package com.rarestzhou.leetcode_solutions.java.sorting;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2021/4/27 10:45
 * @description: 插入排序
 */
public class InsertionSortSolutions {

    /**
     * 插入排序（已排序区域+未排序区域）- 稳定排序
     *
     * 时间复杂度：最好-O(N)，最坏-O(N^2)，平均-O(N^2)
     * 空间复杂度：O(1)，原地排序
     *
     * @param arr       数组
     * @param arrLength 数组大小
     */
    public static void insertionSort(int[] arr, int arrLength) {
        if (arrLength <= 1) {
            return;
        }
        // 初始已排序区间只有数组中的第一个元素
        for (int i = 1; i < arrLength; i++) {
            int value = arr[i];
            int j = i - 1;
            // （从尾到头在左边已排序的区域）查找插入的位置
            while (j >= 0 && value < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 插入数据
            arr[j + 1] = value;
        }
    }
}
