package com.rarestzhou.leetcode_solutions.java.sorting;

import java.util.Arrays;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2021/4/27 14:33
 * @description: 归并排序
 */
public class MergeSortSolutions {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 6, 2, 3, 4};
        int[] result = mergeSort(arr, 6);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 递归实现归并排序（稳定的排序算法）
     * 执行效率与原数组的有序程度无关
     *
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(N)
     *
     * @param arr
     * @param arrLength
     */
    public static int[] mergeSort(int[] arr, int arrLength) {
        if (arrLength <= 1) {
            return arr;
        }
        int mid = arrLength / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arrLength);
        return mergeSortConquer(mergeSort(left, left.length), mergeSort(right, right.length));
    }

    private static int[] mergeSortConquer(int[] left, int[] right) {
        // 临时数组
        int[] result = new int[left.length + right.length];
        // TODO by 无朽 2021/4/27 可以用哨兵优化
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

}
