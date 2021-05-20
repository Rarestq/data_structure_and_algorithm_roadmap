package com.rarestzhou.leetcode_solutions.java.sorting;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2021/4/27 11:48
 * @description: 选择排序
 */
public class SelectionSortSolutions {

    public void selectionSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                // 找到最小的数
                if (arr[j] < arr[minIndex]) {
                    // 保存最小的数的索引
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
